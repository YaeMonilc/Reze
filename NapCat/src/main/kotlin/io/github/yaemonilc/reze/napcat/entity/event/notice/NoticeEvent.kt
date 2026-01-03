package io.github.yaemonilc.reze.napcat.entity.event.notice

import io.github.yaemonilc.reze.napcat.entity.event.Event
import io.github.yaemonilc.reze.napcat.entity.event.PostType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class NoticeEvent : Event() {
    override val postType: PostType = PostType.NOTICE
    override val time: Long = System.currentTimeMillis()
    abstract val noticeType: NoticeType
}

@Serializable
enum class NoticeType(
    val value: String
) {
    @SerialName("bot_offline")
    BOT_OFFLINE("bot_offline"),
    @SerialName("friend_add")
    FRIEND_ADD("friend_add"),
    @SerialName("friend_recall")
    FRIEND_RECALL("friend_recall"),
    @SerialName("group_admin")
    GROUP_ADMIN("group_admin"),
    @SerialName("group_ban")
    GROUP_BAN("group_ban"),
    @SerialName("group_card")
    GROUP_CARD("group_card"),
    @SerialName("essence")
    ESSENCE("essence"),
    @SerialName("group_decrease")
    GROUP_DECREASE("group_decrease"),
    @SerialName("group_increase")
    GROUP_INCREASE("group_increase"),
    @SerialName("notify")
    NOTIFY("notify"),
    @SerialName("group_recall")
    GROUP_RECALL("group_recall"),
    @SerialName("group_upload")
    GROUP_UPLOAD("group_upload"),
    @SerialName("group_msg_emoji_like")
    GROUP_MSG_EMOJI_LIKE("group_msg_emoji_like")
}