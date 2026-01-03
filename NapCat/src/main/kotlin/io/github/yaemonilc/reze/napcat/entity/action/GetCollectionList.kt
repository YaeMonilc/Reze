package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("get_collection_list")
data class GetCollectionList(
    override val echo: String? = null
) : Action()