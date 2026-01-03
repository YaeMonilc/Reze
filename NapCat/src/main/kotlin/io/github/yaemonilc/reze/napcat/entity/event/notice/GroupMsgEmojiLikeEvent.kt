package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.Serializable

@Serializable
data class GroupMsgEmojiLikeEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.GROUP_MSG_EMOJI_LIKE,
    override val groupId: Long,
    override val userId: Long,
    val likes: List<MsgEmojiLike>,
    val isAdd: Boolean,
    val messageSeq: String? = null
) : GroupNoticeEvent() {
    @Serializable
    data class MsgEmojiLike(
        val emojiId: String,
        val count: Int
    )
}
