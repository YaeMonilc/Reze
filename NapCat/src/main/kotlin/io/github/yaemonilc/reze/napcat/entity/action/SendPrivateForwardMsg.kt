package io.github.yaemonilc.reze.napcat.entity.action

import io.github.yaemonilc.reze.napcat.entity.type.ForwardSegment
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("send_private_forward_msg")
data class SendPrivateForwardMsg(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val userId: Long,
        val messages: List<ForwardSegment>
    )
}