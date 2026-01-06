package io.github.yaemonilc.reze.core

import io.github.yaemonilc.reze.core.manager.PluginManager
import io.github.yaemonilc.reze.core.manager.SessionManager
import io.github.yaemonilc.reze.core.util.getLogger
import io.github.yaemonilc.reze.napcat.Session
import io.github.yaemonilc.reze.napcat.Session.Companion.convertResponse
import io.github.yaemonilc.reze.napcat.entity.event.Event
import io.github.yaemonilc.reze.napcat.entity.response.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonObject
import java.io.File

class Reze internal constructor() {
    companion object {
        private var instance: Reze? = null

        @PublishedApi
        internal fun initialize(
            pluginDirectory: File,
            pluginPrivateDirectory: File
        ) {
            instance?.let {
                throw IllegalStateException("Reze cannot be initialized!")
            } ?: run {
                instance = Reze()

                getInstance().apply {
                    sessionManager = SessionManager()

                    pluginManager = PluginManager(
                        pluginDirectory = pluginDirectory,
                        basePrivateDirectory = pluginPrivateDirectory
                    )

                    pluginManager.apply {
                        runCatching {
                            loadPlugins()
                        }.onFailure {
                            getLogger<Reze>().error(it.message, it)
                        }
                    }
                }
            }
        }

        internal fun getInstance(): Reze =
            instance ?: throw IllegalStateException("Reze has not been initialized.")
    }

    @PublishedApi
    internal lateinit var pluginManager: PluginManager
    @PublishedApi
    internal lateinit var sessionManager: SessionManager
}

fun initializeReze(
    pluginDirectory: File,
    pluginPrivateDirectory: File
) = Reze.initialize(
    pluginDirectory = pluginDirectory,
    pluginPrivateDirectory = pluginPrivateDirectory
)

fun reze(): Reze = Reze.getInstance()

fun createBot(
    sign: String,
    url: String
) = reze().sessionManager.createBot(
    sign = sign,
    url = url
)

fun subscribeEvent() =
    reze().sessionManager.eventFlow

fun subscribeEvent(
    sign: String
) = subscribeEvent().filter { (session, _) ->
    session.sign == sign
}

@JvmName("subscribeEventGeneric")
inline fun <reified T : Event> subscribeEvent() =
    subscribeEvent().filterIsInstance<T>()

@JvmName("subscribeEventGeneric")
inline fun <reified T : Event> subscribeEvent(
    sign: String
) = subscribeEvent(
    sign = sign
).filterIsInstance<T>()

fun subscribeResponse() =
    reze().sessionManager.responseFlow

fun subscribeResponse(
    sign: String
) = subscribeResponse().filter { (session, _) ->
    session.sign == sign
}

fun subscribeResponseByEcho(
    echo: String
) = subscribeResponse().filter { (_, response) ->
    response.echo == echo
}

fun subscribeResponseByEcho(
    sign: String,
    echo: String
) = subscribeResponse(
    sign = sign
).filter { (_, response) ->
    response.echo == echo
}

fun <T> Flow<Pair<Session, Response<JsonObject>>>.convertResponse(
    deserializer: DeserializationStrategy<T>
) = map {
    Pair(
        first = it.first,
        second = it.second.convertResponse(
            deserializer = deserializer
        )
    )
}
