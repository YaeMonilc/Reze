package io.github.yaemonilc.reze.napcat.entity.action

import io.github.yaemonilc.reze.napcat.entity.type.ForwardSegment
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("send_forward_msg")
data class SendForwardMsg(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val messages: List<ForwardSegment>
    )
}