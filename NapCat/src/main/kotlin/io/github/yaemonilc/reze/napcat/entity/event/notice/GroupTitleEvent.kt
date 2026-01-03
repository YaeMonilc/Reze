package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.Serializable

@Serializable
data class GroupTitleEvent(
    override val selfId: Long,
    override val userId: Long,
    override val groupId: Long,
    override val subType: SubType = SubType.TITLE,
    val title: String
) : GroupNotifyEvent()
