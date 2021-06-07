pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
        maven { url = uri("https://dl.bintray.com/badoo/maven") }
        maven { url = uri("https://maven.google.com") }
    }
}

rootProject.name = "KMWeather"
include(":android")
include(":shared")
include(":web")