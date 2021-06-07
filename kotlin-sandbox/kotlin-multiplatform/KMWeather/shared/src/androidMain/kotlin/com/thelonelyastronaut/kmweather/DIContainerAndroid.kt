package com.thelonelyastronaut.kmweather

import com.thelonelyastronaut.kmweather.di.commonModule
import com.thelonelyastronaut.kmweather.utils.Logger
import com.thelonelyastronaut.kmweather.utils.LoggerImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

internal val androidDI = DI {
    import(commonModule)
    bind<Logger>() with singleton { LoggerImpl }
}

object DIContainerAndroid: DIContainer(androidDI) {}