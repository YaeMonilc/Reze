package io.github.yaemonilc.reze.napcat.entity.action

import io.github.yaemonilc.reze.napcat.entity.type.Segment
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("send_group_msg")
data class SendGroupMsg(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val groupId: Long,
        val message: List<Segment>,
        val autoEscape: Boolean? = null
    )
}