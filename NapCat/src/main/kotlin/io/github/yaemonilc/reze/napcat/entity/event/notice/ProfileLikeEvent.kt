package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileLikeEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.NOTIFY,
    val subType: SubType = SubType.PROFILE_LIKE,
    val operatorId: Long,
    val operatorNick: String,
    val times: Int
) : NoticeEvent() {
    @Serializable
    enum class SubType(
        val value: String
    ) {
        @SerialName("profile_like")
        PROFILE_LIKE("profile_like")
    }
}
