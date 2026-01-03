package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_recent_contact")
data class GetRecentContact(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val count: String
    )
}