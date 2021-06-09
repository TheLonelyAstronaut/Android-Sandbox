package com.thelonelyastronaut.kmweather.di.repository

import com.thelonelyastronaut.kmweather.di.repository.database.databaseModule
import com.thelonelyastronaut.kmweather.di.repository.network.networkModule
import com.thelonelyastronaut.kmweather.repository.WeatherRepository
import com.thelonelyastronaut.kmweather.repository.WeatherRepositoryImpl
import com.thelonelyastronaut.kmweather.repository.database.WeatherDatabase
import com.thelonelyastronaut.kmweather.repository.network.WeatherCommunicator
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val repositoryModule = DI.Module("RepositoryModule") {
    import(networkModule)
    import(databaseModule)

    bind<WeatherRepository>() with singleton {
        WeatherRepositoryImpl(instance<WeatherCommunicator>(), instance<WeatherDatabase>())
    }
}