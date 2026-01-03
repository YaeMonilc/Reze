package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.Serializable

@Serializable
data class FriendRecallEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.FRIEND_RECALL,
    val userId: Long,
    val messageId: Long
) : NoticeEvent()
