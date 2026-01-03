@file:OptIn(ExperimentalCoroutinesApi::class)

package io.github.yaemonilc.reze.core.manager

import io.github.yaemonilc.reze.core.util.getLogger
import io.github.yaemonilc.reze.napcat.Session
import io.github.yaemonilc.reze.napcat.entity.event.Event
import io.github.yaemonilc.reze.napcat.entity.response.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonObject
import java.net.SocketTimeoutException

@PublishedApi
internal class SessionManager {
    private val sessions = MutableStateFlow(emptyList<Session>())

    internal val eventFlow: Flow<Pair<Session, Event>>
        get() = sessions.flatMapLatest { sessions ->
            sessions.map { session ->
                session.subscribeEvent().map {
                    Pair(
                        first = session,
                        second = it
                    )
                }
            }.merge()
        }
    internal val responseFlow: Flow<Pair<Session, Response<JsonObject>>>
        get() = sessions.flatMapLatest { sessions ->
            sessions.map { session ->
                session.subscribeResponse().map {
                    Pair(
                        first = session,
                        second = it
                    )
                }
            }.merge()
        }

    internal fun createBot(
        sign: String,
        url: String
    ) = sessions.update { sessions ->
        sessions + Session(
            sign = sign,
            url = url
        ).apply {
            CoroutineScope(Default + SupervisorJob()).launch {
                runCatching {
                    connect()
                }.onFailure {
                    if (it is SocketTimeoutException) {
                        getLogger<SessionManager>().error("Bot: {} timeout", sign)
                    }
                }
            }
        }
    }
}