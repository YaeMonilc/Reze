package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_doubt_friends_add_request")
data class GetDoubtFriendsAddRequest(
    override val echo: String? = null
) : Action()