package io.github.yaemonilc.reze.launcher

import io.github.yaemonilc.reze.core.createSession
import io.github.yaemonilc.reze.core.initializeReze
import io.github.yaemonilc.reze.launcher.entity.Config
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.serialization.json.Json
import java.io.File

private val json = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
    encodeDefaults = true
}

val config: Config
    get() = File("./config.json").run {
        if (!exists()) {
            Config().also {
                writeText(
                    text = json.encodeToString(it)
                )
            }
        }

        json.decodeFromString<Config>(
            string = readText()
        )
    }

suspend fun main() {
    suspendCancellableCoroutine<Unit> {
        config.let {
            initializeReze(
                pluginDirectory = File(
                    it.pluginDirectory
                ).apply {
                    if (!exists())
                        mkdirs()
                },
                pluginPrivateDirectory = File(
                    it.pluginPrivateDirectory
                ).apply {
                    if (!exists())
                        mkdirs()
                }
            )

            it.bots.forEach { (sign, url) ->
                createSession(
                    sign = sign,
                    url = url
                )
            }
        }
    }
}