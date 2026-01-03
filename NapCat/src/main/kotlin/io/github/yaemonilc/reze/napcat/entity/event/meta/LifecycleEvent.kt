package io.github.yaemonilc.reze.napcat.entity.event.meta

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LifecycleEvent(
    override val selfId: Long,
    override val metaEventType: MetaEventType = MetaEventType.LIFECYCLE,
    val subType: SubType
) : MetaEvent() {
    @Serializable
    enum class SubType {
        @SerialName("enable")
        ENABLE,
        @SerialName("disable")
        DISABLE,
        @SerialName("connect")
        CONNECT
    }
}