package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("bot_exit")
data class BotExit(
    override val echo: String? = null
) : Action()