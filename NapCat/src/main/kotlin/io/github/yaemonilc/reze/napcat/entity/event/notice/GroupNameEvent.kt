package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.Serializable

@Serializable
data class GroupNameEvent(
    override val selfId: Long,
    override val userId: Long,
    override val groupId: Long,
    override val subType: SubType = SubType.GROUP_NAME,
    val nameNew: String
) : GroupNotifyEvent()
