package com.thelonelyastronaut.kmweather.di.network

import NetworkService
import com.thelonelyastronaut.kmweather.repository.network.INetworkProvider
import com.thelonelyastronaut.kmweather.utils.ILogger
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val networkModule = DI.Module("Network") {
    bind<INetworkProvider>() with singleton { NetworkService(instance<ILogger>()) }
}