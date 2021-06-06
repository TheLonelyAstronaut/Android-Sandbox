package com.thelonelyastronaut.kmweather.di.network

import NetworkService
import com.thelonelyastronaut.kmweather.network.INetworkProvider
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val testModule = DI.Module("Network") {
    bind<INetworkProvider>() with singleton { NetworkService() }
}