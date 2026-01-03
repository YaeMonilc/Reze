package io.github.yaemonilc.reze.napcat.entity.event.message

import io.github.yaemonilc.reze.napcat.entity.type.GroupSender
import io.github.yaemonilc.reze.napcat.entity.type.Segment
import kotlinx.serialization.Serializable

@Serializable
data class GroupMessageEvent(
    override val selfId: Long,
    override val messageType: MessageType = MessageType.GROUP,
    override val subType: SubType = SubType.NORMAL,
    override val messageId: Long,
    override val userId: Long,
    override val message: List<Segment>,
    override val rawMessage: String,
    override val font: Int,
    val groupId: Long,
    val sender: GroupSender
) : MessageEvent()