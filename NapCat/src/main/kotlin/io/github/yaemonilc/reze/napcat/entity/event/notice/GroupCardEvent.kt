package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.Serializable

@Serializable
data class GroupCardEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.GROUP_CARD,
    override val userId: Long,
    override val groupId: Long,
    val cardNew: String,
    val cardOld: String
) : GroupNoticeEvent()
