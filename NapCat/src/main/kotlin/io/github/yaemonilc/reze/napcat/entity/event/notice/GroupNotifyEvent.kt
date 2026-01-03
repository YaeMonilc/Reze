package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class GroupNotifyEvent : GroupNoticeEvent() {
    override val noticeType: NoticeType = NoticeType.NOTIFY
    abstract val subType: SubType

    @Serializable
    enum class SubType(
        val value: String
    ) {
        @SerialName("group_name")
        GROUP_NAME("group_name"),
        @SerialName("title")
        TITLE("title")

    }
}