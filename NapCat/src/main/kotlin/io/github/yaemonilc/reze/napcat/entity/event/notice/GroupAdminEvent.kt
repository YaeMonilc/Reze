package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupAdminEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.GROUP_ADMIN,
    override val userId: Long,
    override val groupId: Long,
    val subType: SubType
) : GroupNoticeEvent() {
    @Serializable
    enum class SubType {
        @SerialName("set")
        SET,
        @SerialName("unset")
        UNSET
    }
}