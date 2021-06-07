package com.thelonelyastronaut.kmweather.di

import com.thelonelyastronaut.kmweather.di.domain.domainModule
import com.thelonelyastronaut.kmweather.di.repository.network.networkModule
import com.thelonelyastronaut.kmweather.di.repository.database.databaseModule
import org.kodein.di.DI

val commonModule = DI.Module("MainModule") {
    import(networkModule)
    import(databaseModule)
    import(domainModule)
}

