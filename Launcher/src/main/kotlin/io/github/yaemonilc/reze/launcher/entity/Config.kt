package io.github.yaemonilc.reze.launcher.entity

import kotlinx.serialization.Serializable

@Serializable
data class Config(
    val pluginDirectory: String = "./plugins",
    val pluginPrivateDirectory: String = "./data/plugin",
    val bots: Map<String, String> = mapOf()
)