package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_group_at_all_remain")
data class GetGroupAtAllRemain(
    override val echo: String? = null,
    val params: Params
) : Action() {
    @Serializable
    data class Params(
        val groupId: Long
    )
}