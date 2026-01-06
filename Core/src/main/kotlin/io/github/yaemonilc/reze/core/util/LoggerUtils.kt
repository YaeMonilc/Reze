package io.github.yaemonilc.reze.core.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

inline fun <reified T> getLogger(): Logger =
    LoggerFactory.getLogger(T::class.java)

fun getLogger(
    kClass: KClass<*>
): Logger = LoggerFactory.getLogger(kClass::class.java)