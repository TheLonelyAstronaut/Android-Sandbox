package com.thelonelyastronaut.kmweather.di

import com.thelonelyastronaut.kmweather.di.network.testModule
import org.kodein.di.DI

val mainModule = DI.Module("MainModule") {
    import(testModule)
}


