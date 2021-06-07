plugins {
    kotlin("js")
}

group = "me.thelonelyastronaut"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
    maven(url = "https://dl.bintray.com/kotlin/kotlin-dev")
    maven(url = "https://plugins.gradle.org/m2/")
}

dependencies {
    testImplementation(kotlin("test-js"))
    implementation(kotlin("stdlib-js"))
    implementation(npm("copy-webpack-plugin", "6.4.1"))
    implementation(npm("crypto-browserify", "3.12.0"))
    implementation("org.kodein.di:kodein-di:7.6.0")
    implementation("com.badoo.reaktive:reaktive:1.1.22")
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-router-dom:5.1.2-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-redux:4.0.0-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-redux:5.0.7-pre.113-kotlin-1.4.0")
    implementation(project(":shared"))
}

kotlin {
    js(LEGACY) {
        browser {
            binaries.executable()
            webpackTask {
                cssSupport.enabled = true
            }
            runTask {
                cssSupport.enabled = true
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
    }
}

rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().versions.webpackCli.version = "3.3.12"
}