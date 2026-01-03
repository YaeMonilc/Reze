package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("nc_get_packet_status")
data class NcGetPacketStatus(
    override val echo: String? = null
) : Action()