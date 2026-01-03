package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.Serializable

@Serializable
data class FriendAddEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.FRIEND_ADD,
    val userId: Long
) : NoticeEvent()
