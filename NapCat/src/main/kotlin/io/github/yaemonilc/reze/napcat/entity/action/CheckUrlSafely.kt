package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("check_url_safely")
data class CheckUrlSafely(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val url: String
    )
}