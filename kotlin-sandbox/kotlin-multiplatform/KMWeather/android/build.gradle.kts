plugins {
    id("com.android.application")
    kotlin("android")
}

val kodeinVersion = "7.6.0"
val reactiveVersion = "1.1.22"

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("org.kodein.di:kodein-di-framework-android-x:$kodeinVersion")
    implementation("com.badoo.reaktive:reaktive:$reactiveVersion")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.thelonelyastronaut.kmweather.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}