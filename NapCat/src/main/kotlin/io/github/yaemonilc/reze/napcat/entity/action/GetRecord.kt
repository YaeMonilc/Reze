package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_record")
data class GetRecord(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val file: String,
        val outFormat: String? = null
    )
}