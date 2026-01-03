package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("set_input_status")
data class SetInputStatus(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val userId: Long,
        val eventType: Int
    )
}