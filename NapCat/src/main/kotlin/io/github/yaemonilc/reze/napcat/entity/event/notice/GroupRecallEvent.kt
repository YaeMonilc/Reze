@file:OptIn(ExperimentalSerializationApi::class)

package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
data class GroupRecallEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.GROUP_RECALL,
    override val userId: Long,
    override val groupId: Long,
    val operatorId: Long,
    val messageId: Long
) : GroupNoticeEvent()