package io.github.yaemonilc.reze.napcat.entity.event.request

import kotlinx.serialization.Serializable

@Serializable
data class GroupRequestEvent(
    override val selfId: Long,
    override val requestType: RequestType = RequestType.GROUP,
    val userId: Long,
    val groupId: Long,
    val comment: String,
    val flag: String,
    val subType: String
) : RequestEvent()
