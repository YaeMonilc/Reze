plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "io.github.yaemonilc.reze.napcat"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-reflect
    api("org.jetbrains.kotlin:kotlin-reflect:2.3.0")
    // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-serialization-json
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
    // https://mvnrepository.com/artifact/io.ktor/ktor-client-core
    api("io.ktor:ktor-client-core:3.3.3")
    // https://mvnrepository.com/artifact/io.ktor/ktor-client-okhttp-jvm
    api("io.ktor:ktor-client-okhttp-jvm:3.3.3")
    // https://mvnrepository.com/artifact/io.ktor/ktor-client-websocket
    api("io.ktor:ktor-client-websocket:1.1.4") {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-reflect")
    }
    // https://mvnrepository.com/artifact/io.ktor/ktor-serialization-kotlinx-json
    api("io.ktor:ktor-serialization-kotlinx-json:3.3.3")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}