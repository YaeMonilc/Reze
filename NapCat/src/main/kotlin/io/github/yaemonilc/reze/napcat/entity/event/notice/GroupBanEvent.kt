package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupBanEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.GROUP_BAN,
    override val userId: Long,
    override val groupId: Long,
    val operatorId: Long,
    val duration: Long,
    val subType: SubType
) : GroupNoticeEvent() {
    @Serializable
    enum class SubType {
        @SerialName("ban")
        BAN,
        @SerialName("lift_ban")
        LIFT_BAN
    }
}