package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_group_system_msg")
data class GetGroupSystemMsg(
    override val echo: String? = null
) : Action()