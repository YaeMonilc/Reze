package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupDecreaseEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.GROUP_DECREASE,
    override val userId: Long,
    override val groupId: Long,
    val subType: SubType,
    val operatorId: Long
) : GroupNoticeEvent() {
    @Serializable
    enum class SubType {
        @SerialName("leave")
        LEAVE,
        @SerialName("kick")
        KICK,
        @SerialName("kick_me")
        KICK_ME,
        @SerialName("disband")
        DISBAND
    }
}
