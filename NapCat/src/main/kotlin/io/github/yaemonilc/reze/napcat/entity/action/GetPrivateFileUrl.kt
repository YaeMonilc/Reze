package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_private_file_url")
data class GetPrivateFileUrl(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val fileId: String
    )
}
