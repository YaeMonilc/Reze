package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("handle_quick_operation")
data class HandleQuickOperation(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val context: Map<String, String>,
        val operation: Map<String, String>
    )
}