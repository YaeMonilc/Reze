package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_guild_list")
data class GetGuildList(
    override val echo: String? = null
) : Action()