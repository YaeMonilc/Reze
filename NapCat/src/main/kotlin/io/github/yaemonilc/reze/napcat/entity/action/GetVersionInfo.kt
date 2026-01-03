package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_version_info")
data class GetVersionInfo(
    override val echo: String? = null
) : Action()