package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("_set_model_show")
data class SetModelShow(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val model: String,
        val modelShow: String
    )
}