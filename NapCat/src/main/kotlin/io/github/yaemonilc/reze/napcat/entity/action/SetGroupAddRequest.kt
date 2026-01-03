package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("set_group_add_request")
data class SetGroupAddRequest(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val flag: String,
        val approve: Boolean,
        val reason: String? = null
    )
}