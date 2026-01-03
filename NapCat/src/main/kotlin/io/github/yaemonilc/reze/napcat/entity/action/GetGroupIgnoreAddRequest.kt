package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_group_ignore_add_request")
data class GetGroupIgnoreAddRequest(
    override val echo: String? = null
) : Action()