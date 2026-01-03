package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("upload_private_file")
data class UploadPrivateFile(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val userId: Long,
        val file: String,
        val name: String
    )
}