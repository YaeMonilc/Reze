package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("mark_group_msg_as_read")
data class MarkGroupMsgAsRead(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val groupId: Long,
        val time: Int
    )
}