plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.gradleup.shadow")
}

group = "io.github.yaemonilc.reze.launcher"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    implementation("ch.qos.logback:logback-classic:1.5.22")

    implementation(project(":Core"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}