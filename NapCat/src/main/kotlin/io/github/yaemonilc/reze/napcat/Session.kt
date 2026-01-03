@file:OptIn(ExperimentalSerializationApi::class)

package io.github.yaemonilc.reze.napcat

import io.github.yaemonilc.reze.napcat.entity.action.Action
import io.github.yaemonilc.reze.napcat.entity.event.Event
import io.github.yaemonilc.reze.napcat.entity.response.Response
import io.github.yaemonilc.reze.napcat.util.getLogger
import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.sendSerialized
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import io.ktor.util.logging.error
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy
import kotlinx.serialization.json.JsonObject

class Session(
    val sign: String,
    private val url: String
) {
    companion object {
        private val json = Json {
            ignoreUnknownKeys = true
            encodeDefaults = true
            namingStrategy = JsonNamingStrategy.SnakeCase
        }

        private val client = HttpClient {
            install(WebSockets) {
                contentConverter = KotlinxWebsocketSerializationConverter(
                    format = json
                )
            }
        }

        fun <T> Response<JsonObject>.convertResponse(
            deserializer: DeserializationStrategy<T>
        ) = run {
            Response(
                status = status,
                data = data?.let {
                    json.decodeFromJsonElement(
                        deserializer = deserializer,
                        element = it
                    )
                },
                message = message,
                wording = wording,
                echo = echo
            )
        }
    }

    @PublishedApi
    internal val receiveFlow = MutableSharedFlow<Any>()
    private val actionFlow = MutableSharedFlow<Any>()

    suspend fun connect() {
        client.webSocket(
            urlString = url
        ) {
            launch {
                actionFlow.collect {
                    if (it is Action) {
                        getLogger<Session>().info("Bot: {} -> {}", sign, it)
                        sendSerialized(it)
                    }
                }
            }

            incoming.consumeAsFlow()
                .filterIsInstance<Frame.Text>()
                .map { it.readText() }
                .collect { value ->
                    getLogger<Session>().debug("Bot: {} <- {}", sign, value)

                    runCatching {
                        (json.parseToJsonElement(value) as JsonObject).let { obj ->
                            receiveFlow.emit(
                                value = json.decodeFromJsonElement(
                                    deserializer = when {
                                        "status" in obj && "message" in obj ->
                                            Response.serializer(JsonObject.serializer())
                                        else -> Event.serializer()
                                    },
                                    element = obj
                                ).also {
                                    getLogger<Session>().info("Bot: {} <- {}", sign, it)
                                }
                            )
                        }
                    }.onFailure {
                        getLogger<Session>().error(it)
                    }
                }
        }
    }

    suspend fun emitAction(
        action: Action
    ) = actionFlow.emit(action)

    fun subscribeEvent() =
        receiveFlow.filterIsInstance<Event>()

    fun subscribeResponse() =
        receiveFlow.filterIsInstance<Response<JsonObject>>()
}