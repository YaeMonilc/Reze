package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_mini_app_ark")
data class GetMiniAppArk(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val appid: String,
        val view: String,
        val payload: String
    )
}