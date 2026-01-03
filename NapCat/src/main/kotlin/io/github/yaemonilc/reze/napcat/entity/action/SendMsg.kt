package io.github.yaemonilc.reze.napcat.entity.action

import io.github.yaemonilc.reze.napcat.entity.event.message.MessageEvent
import io.github.yaemonilc.reze.napcat.entity.type.Segment
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("send_msg")
data class SendMsg(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val messageType: MessageEvent.MessageType,
        val userId: Long? = null,
        val groupId: Long? = null,
        val message: List<Segment>,
        val autoEscape: Boolean? = null
    )
}