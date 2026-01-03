package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("set_diy_online_status")
data class SetDiyOnlineStatus(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val faceId: Long,
        val faceType: String,
        val wording: String
    )
}