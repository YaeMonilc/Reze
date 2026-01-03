package io.github.yaemonilc.reze.core.entity

import io.github.yaemonilc.reze.core.IPlugin
import java.io.File

data class RegisteredPlugin(
    val name: String,
    val privateDirectory: File,
    val instance: IPlugin
)
