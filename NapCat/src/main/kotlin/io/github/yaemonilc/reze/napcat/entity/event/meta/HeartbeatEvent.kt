package io.github.yaemonilc.reze.napcat.entity.event.meta

import kotlinx.serialization.Serializable

@Serializable
data class HeartbeatEvent(
    override val selfId: Long,
    override val metaEventType: MetaEventType = MetaEventType.HEARTBEAT,
    val status: Status
) : MetaEvent() {
    @Serializable
    data class Status(
        val interval: Long? = null
    )
}
