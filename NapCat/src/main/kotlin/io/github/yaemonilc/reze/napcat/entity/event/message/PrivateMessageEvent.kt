package io.github.yaemonilc.reze.napcat.entity.event.message

import io.github.yaemonilc.reze.napcat.entity.type.FriendSender
import io.github.yaemonilc.reze.napcat.entity.type.Segment
import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessageEvent(
    override val selfId: Long,
    override val messageType: MessageType = MessageType.PRIVATE,
    override val subType: SubType = SubType.FRIEND,
    override val messageId: Long,
    override val userId: Long,
    override val message: List<Segment>,
    override val rawMessage: String,
    override val font: Int,
    val targetId: Long? = null,
    val sender: FriendSender
) : MessageEvent()
