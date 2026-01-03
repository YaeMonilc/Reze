package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("set_group_card")
data class SetGroupCard(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val groupId: Long,
        val userId: Long,
        val card: String
    )
}
