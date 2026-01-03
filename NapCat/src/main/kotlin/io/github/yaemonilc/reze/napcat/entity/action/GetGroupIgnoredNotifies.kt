package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_group_ignored_notifies")
data class GetGroupIgnoredNotifies(
    override val echo: String? = null
) : Action()