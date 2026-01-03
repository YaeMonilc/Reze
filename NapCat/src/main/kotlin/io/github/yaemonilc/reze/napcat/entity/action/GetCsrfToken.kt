package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_csrf_token")
data class GetCsrfToken(
    override val echo: String? = null
) : Action()