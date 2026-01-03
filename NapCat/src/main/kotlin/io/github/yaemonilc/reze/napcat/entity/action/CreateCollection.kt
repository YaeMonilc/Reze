package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("create_collection")
data class CreateCollection(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val content: String
    )
}