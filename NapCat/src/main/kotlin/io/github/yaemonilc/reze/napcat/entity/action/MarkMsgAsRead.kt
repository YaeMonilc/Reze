package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("mark_msg_as_read")
data class MarkMsgAsRead(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val messageId: Long
    )
}