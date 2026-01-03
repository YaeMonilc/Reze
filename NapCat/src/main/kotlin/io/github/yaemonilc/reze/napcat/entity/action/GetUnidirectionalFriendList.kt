package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_unidirectional_friend_list")
data class GetUnidirectionalFriendList(
    override val echo: String? = null
) : Action()