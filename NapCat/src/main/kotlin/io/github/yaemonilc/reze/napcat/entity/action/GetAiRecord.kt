package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_ai_record")
data class GetAiRecord(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val character: String,
        val groupId: Long,
        val text: String
    )
}