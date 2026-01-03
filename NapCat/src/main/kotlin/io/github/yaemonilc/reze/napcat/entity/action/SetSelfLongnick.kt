package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("set_self_longnick")
data class SetSelfLongnick(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val longNick: String
    )
}