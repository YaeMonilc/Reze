package io.github.yaemonilc.reze.core

import io.github.yaemonilc.reze.core.entity.RegisteredPlugin
import java.io.File

interface IPlugin {
    suspend fun onLoaded()
}

object Plugin {
    @PublishedApi
    internal inline fun <reified T : IPlugin> registeredInstance(): RegisteredPlugin? =
        reze().pluginManager.byClazz(
            clazz = T::class
        )

    inline fun <reified T : IPlugin> instance(): T =
        registeredInstance<T>()?.instance as? T
            ?: throw NullPointerException("Not found instance of ${T::class.simpleName}")

    inline fun <reified T : IPlugin> privateDirectory(): File =
        registeredInstance<T>()?.privateDirectory?.apply {
            if (!exists())
                mkdirs()
        } ?: throw NullPointerException("Not found instance of ${T::class.simpleName}")
}