package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.Serializable

@Serializable
abstract class GroupNoticeEvent : NoticeEvent() {
    abstract val userId: Long
    abstract val groupId: Long
}