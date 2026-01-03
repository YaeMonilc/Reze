@file:OptIn(ExperimentalSerializationApi::class)

package io.github.yaemonilc.reze.napcat.entity.action

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@JsonClassDiscriminator("action")
sealed class Action {
    abstract val echo: String?
}