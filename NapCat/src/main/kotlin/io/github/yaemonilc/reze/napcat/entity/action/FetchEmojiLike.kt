package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("fetch_emoji_like")
data class FetchEmojiLike(
    override val echo: String? = null
) : Action()