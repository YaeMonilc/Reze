package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("_mark_all_as_read")
data class MarkAllAsRead(
    override val echo: String? = null
) : Action()