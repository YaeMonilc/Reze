package io.github.yaemonilc.reze.napcat.util

import org.slf4j.LoggerFactory

internal inline fun <reified T> getLogger() =
    LoggerFactory.getLogger(T::class.java)