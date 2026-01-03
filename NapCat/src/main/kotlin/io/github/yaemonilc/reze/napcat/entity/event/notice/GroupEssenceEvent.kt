package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupEssenceEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.ESSENCE,
    override val userId: Long,
    override val groupId: Long,
    val senderId: Long,
    val operatorId: Long,
    val subType: SubType
) : GroupNoticeEvent() {
    @Serializable
    enum class SubType {
        @SerialName("add")
        ADD,
        @SerialName("delete")
        DELETE
    }
}
