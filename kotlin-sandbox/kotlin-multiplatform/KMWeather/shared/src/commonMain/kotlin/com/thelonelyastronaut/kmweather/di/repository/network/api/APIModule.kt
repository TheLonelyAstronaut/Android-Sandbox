package com.thelonelyastronaut.kmweather.di.repository.network.api

import com.thelonelyastronaut.kmweather.repository.network.api.WeatherAPIService
import com.thelonelyastronaut.kmweather.repository.network.api.WeatherAPIServiceImpl
import com.thelonelyastronaut.kmweather.utils.Logger
import io.ktor.client.*
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val APIModule = DI.Module("APIModule") {
    bind<HttpClient>() with singleton { HttpClient() }

    bind<WeatherAPIService>() with singleton { WeatherAPIServiceImpl(instance<Logger>(), instance<HttpClient>()) }
}