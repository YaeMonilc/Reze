package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("set_qq_profile")
data class SetQQProfile(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val nickname: String? = null,
        val company: String? = null,
        val email: String? = null,
        val college: String? = null,
        val personalNote: String? = null
    )
}