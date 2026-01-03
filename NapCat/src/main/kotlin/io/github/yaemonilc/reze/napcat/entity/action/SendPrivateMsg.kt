package io.github.yaemonilc.reze.napcat.entity.action

import io.github.yaemonilc.reze.napcat.entity.type.Segment
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("send_private_msg")
data class SendPrivateMsg(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val userId: Long,
        val message: List<Segment>,
        val autoEscape: Boolean? = null
    )
}