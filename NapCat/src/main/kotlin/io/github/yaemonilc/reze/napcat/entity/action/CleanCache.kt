package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("clean_cache")
data class CleanCache(
    override val echo: String? = null
) : Action()