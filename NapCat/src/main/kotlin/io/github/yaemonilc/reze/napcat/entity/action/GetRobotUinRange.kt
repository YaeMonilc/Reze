package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_robot_uin_range")
data class GetRobotUinRange(
    override val echo: String? = null
) : Action()