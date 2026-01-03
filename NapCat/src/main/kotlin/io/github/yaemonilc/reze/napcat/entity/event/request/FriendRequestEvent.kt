package io.github.yaemonilc.reze.napcat.entity.event.request

import kotlinx.serialization.Serializable

@Serializable
data class FriendRequestEvent(
    override val selfId: Long,
    override val requestType: RequestType = RequestType.FRIEND,
    val userId: Long,
    val comment: String,
    val flag: String
) : RequestEvent()
