package io.github.yaemonilc.reze.core

interface IPlugin {
    suspend fun onLoaded()
}

inline fun <reified T : IPlugin> instance(): T =
    reze().pluginManager.byClazz(
        clazz = T::class
    )?.instance as? T ?: throw NullPointerException("Not found instance of ${T::class.simpleName}")