package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("translate_en2zh")
data class TranslateEn2Zh(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val text: String
    )
}
