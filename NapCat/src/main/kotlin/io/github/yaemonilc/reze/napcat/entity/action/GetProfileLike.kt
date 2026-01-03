package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_profile_like")
data class GetProfileLike(
    override val echo: String? = null
) : Action()