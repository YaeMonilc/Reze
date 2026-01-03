package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_credentials")
data class GetCredentials(
    override val echo: String? = null,
    val params: Params? = null
) : Action() {
    @Serializable
    data class Params(
        val domain: String? = null
    )
}