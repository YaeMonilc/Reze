plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "Reze"

include("Core")
include("NapCat")
include("Launcher")