package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("set_msg_emoji_like")
data class SetMsgEmojiLike(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val messageId: Long,
        val emojiId: Long,
        val emojiType: Int? = null
    )
}