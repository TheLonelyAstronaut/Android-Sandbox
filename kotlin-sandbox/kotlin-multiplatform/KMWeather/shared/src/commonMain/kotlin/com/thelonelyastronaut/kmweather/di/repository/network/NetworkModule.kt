package com.thelonelyastronaut.kmweather.di.repository.network

import com.thelonelyastronaut.kmweather.di.repository.network.api.APIModule
import com.thelonelyastronaut.kmweather.repository.network.WeatherCommunicator
import com.thelonelyastronaut.kmweather.repository.network.WeatherCommunicatorImpl
import com.thelonelyastronaut.kmweather.repository.network.api.WeatherAPIServiceImpl
import com.thelonelyastronaut.kmweather.repository.network.api.WeatherAPIService
import com.thelonelyastronaut.kmweather.utils.Logger
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val networkModule = DI.Module("Network") {
   import(APIModule)

    bind<WeatherCommunicator>() with singleton { WeatherCommunicatorImpl(instance<WeatherAPIService>()) }
}