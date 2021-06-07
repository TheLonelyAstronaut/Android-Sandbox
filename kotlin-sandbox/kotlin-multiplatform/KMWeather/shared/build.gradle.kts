import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("com.squareup.sqldelight")
    id("kotlinx-serialization")
}

version = "1.0"
val ktorVersion = "1.5.3"
val sqlDelightVersion = "1.5.0"
val kodeinVersion = "7.6.0"
val mokoMvvmVersion = "0.10.1"
val reactiveVersion = "1.1.22"

kotlin {
    android()

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

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../ios/Podfile")
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.kodein.di:kodein-di:$kodeinVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")

                implementation("com.badoo.reaktive:reaktive:$reactiveVersion")
                implementation("com.badoo.reaktive:reaktive-annotations:$reactiveVersion")
                implementation("com.badoo.reaktive:coroutines-interop:$reactiveVersion")

                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")

                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")

                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:$ktorVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.2.1")

                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:$ktorVersion")

                implementation("com.squareup.sqldelight:sqljs-driver:$sqlDelightVersion")
            }
        }
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(30)
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}