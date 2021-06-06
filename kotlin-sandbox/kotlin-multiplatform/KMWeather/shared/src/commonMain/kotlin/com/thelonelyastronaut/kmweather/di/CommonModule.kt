package com.thelonelyastronaut.kmweather.di

import com.thelonelyastronaut.kmweather.di.network.networkModule
import com.thelonelyastronaut.kmweather.di.database.databaseModule
import org.kodein.di.DI

val commonModule = DI.Module("MainModule") {
    import(networkModule)
    import(databaseModule)
}

