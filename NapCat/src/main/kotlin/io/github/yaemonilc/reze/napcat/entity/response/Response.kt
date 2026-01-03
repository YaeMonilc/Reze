package io.github.yaemonilc.reze.napcat.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val status: Status,
    val data: T? = null,
    val message: String,
    val wording: String,
    val echo: String? = null
)

@Serializable
enum class Status {
    @SerialName("ok")
    OK,
    @SerialName("async")
    ASYNC,
    @SerialName("failed")
    FAILED
}