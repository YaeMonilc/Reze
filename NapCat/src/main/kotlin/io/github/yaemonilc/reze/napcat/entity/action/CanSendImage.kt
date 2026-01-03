package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("can_send_image")
data class CanSendImage(
    override val echo: String? = null
) : Action()