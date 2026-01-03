package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_ai_characters")
data class GetAiCharacters(
    override val echo: String? = null
) : Action()