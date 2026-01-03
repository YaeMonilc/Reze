package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(".ocr_image")
data class DotOcrImage(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val image: String
    )
}