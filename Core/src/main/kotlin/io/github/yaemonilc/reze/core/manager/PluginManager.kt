package io.github.yaemonilc.reze.core.manager

import io.github.yaemonilc.reze.core.IPlugin
import io.github.yaemonilc.reze.core.entity.RegisteredPlugin
import io.github.yaemonilc.reze.core.util.getLogger
import io.ktor.util.logging.error
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.File
import java.net.URLClassLoader
import java.util.Properties
import java.util.jar.JarFile
import kotlin.reflect.KClass

@PublishedApi
internal class PluginManager(
    private val pluginDirectory: File,
    private val basePrivateDirectory: File
) {
    private val registeredPlugins = mutableListOf<RegisteredPlugin>()

    internal fun loadPlugins() {
        pluginDirectory.listFiles {
            it.isFile && it.name.endsWith(".jar")
        }.forEach { pluginFile ->
            URLClassLoader(
                arrayOf(pluginFile.toURI().toURL()),
                Thread.currentThread().contextClassLoader
            ).apply {
                JarFile(pluginFile).use { jarFile ->
                    jarFile.apply {
                        entries().toList().let { entries ->
                            entries.find {
                                it.name == "plugin.properties"
                            }?.let { entity ->
                                Properties().apply {
                                    load(getResourceAsStream(entity.name))
                                }
                            }
                        }?.let { properties ->
                            (loadClass(properties["plugin.class"] as String)
                                .getDeclaredConstructor()
                                .newInstance() as IPlugin)
                                .let { plugin ->
                                    (properties["plugin.name"] as String).let { name ->
                                        registeredPlugins.add(
                                            element = RegisteredPlugin(
                                                name = name,
                                                privateDirectory = File(
                                                    basePrivateDirectory,
                                                    plugin::class.qualifiedName!!
                                                ),
                                                instance = plugin
                                            )
                                        )

                                        CoroutineScope(Default + SupervisorJob()).launch {
                                            runCatching {
                                                plugin.onLoaded()
                                            }.onFailure {
                                                getLogger(
                                                    kClass = plugin::class
                                                ).error(it)
                                            }
                                        }

                                        getLogger<PluginManager>().info("Load plugin: {}", name)
                                    }
                                }
                        } ?: throw IllegalStateException("Failed to load plugin ${pluginFile}!")
                    }
                }
            }
        }
    }

    @PublishedApi
    internal fun byClazz(
        clazz: KClass<*>,
    ) = registeredPlugins.find { (_, _, instance) ->
        instance::class == clazz
    }
}