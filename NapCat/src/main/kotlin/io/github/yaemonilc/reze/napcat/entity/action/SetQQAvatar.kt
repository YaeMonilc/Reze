package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("set_qq_avatar")
data class SetQQAvatar(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val file: String
    )
}