package com.thelonelyastronaut.kmweather.di.repository.network

import com.thelonelyastronaut.kmweather.repository.network.api.APIServiceImpl
import com.thelonelyastronaut.kmweather.repository.network.api.APIService
import com.thelonelyastronaut.kmweather.utils.Logger
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val networkModule = DI.Module("Network") {
    bind<APIService>() with singleton { APIServiceImpl(instance<Logger>()) }
}