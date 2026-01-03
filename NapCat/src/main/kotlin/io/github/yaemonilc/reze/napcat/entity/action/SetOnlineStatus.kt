package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("set_online_status")
data class SetOnlineStatus(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val status: Int
    )
}