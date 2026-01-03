package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("fetch_custom_face")
data class FetchCustomFace(
    override val echo: String? = null
) : Action()
