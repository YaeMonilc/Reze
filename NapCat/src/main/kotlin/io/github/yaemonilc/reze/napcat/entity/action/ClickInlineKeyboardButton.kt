package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("click_inline_keyboard_button")
data class ClickInlineKeyboardButton(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val groupId: Long,
        val botAppid: String,
        val buttonId: String,
        val callbackData: String,
        val msgSeq: String
    )
}