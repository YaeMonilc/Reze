package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("_get_model_show")
data class GetModelShow(
    override val echo: String? = null
) : Action()