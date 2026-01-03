package io.github.yaemonilc.reze.core.util

import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

internal inline fun <reified T> getLogger() =
    LoggerFactory.getLogger(T::class.java)

internal fun getLogger(
    kClass: KClass<*>
) = LoggerFactory.getLogger(kClass::class.java)