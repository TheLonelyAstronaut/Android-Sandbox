pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        //maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
    }
}

rootProject.name = "KMWeather"
include(":android")
include(":shared")
include(":web")