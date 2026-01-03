package io.github.yaemonilc.reze.napcat.entity.event.meta

import io.github.yaemonilc.reze.napcat.entity.event.Event
import io.github.yaemonilc.reze.napcat.entity.event.PostType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class MetaEvent : Event() {
    override val postType: PostType = PostType.META_EVENT
    override val time: Long = System.currentTimeMillis()
    abstract val metaEventType: MetaEventType
}

@Serializable
enum class MetaEventType(
    val value: String
) {
    @SerialName("lifecycle")
    LIFECYCLE("lifecycle"),
    @SerialName("heartbeat")
    HEARTBEAT("heartbeat")
}