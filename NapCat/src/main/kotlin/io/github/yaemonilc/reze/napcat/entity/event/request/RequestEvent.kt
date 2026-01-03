package io.github.yaemonilc.reze.napcat.entity.event.request

import io.github.yaemonilc.reze.napcat.entity.event.Event
import io.github.yaemonilc.reze.napcat.entity.event.PostType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class RequestEvent : Event() {
    override val postType: PostType = PostType.REQUEST
    override val time: Long = System.currentTimeMillis()
    abstract val requestType: RequestType
}

@Serializable
enum class RequestType(
    val value: String
) {
    @SerialName("friend")
    FRIEND("friend"),
    @SerialName("group")
    GROUP("group")
}