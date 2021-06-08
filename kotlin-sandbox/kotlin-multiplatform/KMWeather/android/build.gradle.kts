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

    implementation("androidx.compose.ui:ui:1.0.0-beta08")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.0.0-beta08")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.0.0-beta08")
    // Material Design
    implementation("androidx.compose.material:material:1.0.0-beta08")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:1.0.0-beta08")
    implementation("androidx.compose.material:material-icons-extended:1.0.0-beta08")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta08")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.0.0-beta08")

    implementation("androidx.activity:activity-compose:1.3.0-beta01")
    implementation("br.com.devsrsouza.compose.icons.android:erikflowers-weather-icons:0.2.0")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.0-beta08")
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

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    composeOptions {
        kotlinCompilerVersion = "1.5.10"
        kotlinCompilerExtensionVersion = "1.0.0-beta08"
    }
}