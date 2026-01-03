package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("send_packet")
data class SendPacket(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val packet: String
    )
}