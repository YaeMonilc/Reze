package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_friends_with_category")
data class GetFriendsWithCategory(
    override val echo: String? = null
) : Action()