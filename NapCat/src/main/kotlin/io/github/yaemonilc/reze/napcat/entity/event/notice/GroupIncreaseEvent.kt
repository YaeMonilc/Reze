package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupIncreaseEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.GROUP_INCREASE,
    override val userId: Long,
    override val groupId: Long,
    val operatorId: Long,
    val subType: SubType
) : GroupNoticeEvent() {
    @Serializable
    enum class SubType {
        @SerialName("approve")
        APPROVE,
        @SerialName("invite")
        INVITE
    }
}
