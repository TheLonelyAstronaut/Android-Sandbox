package com.thelonelyastronaut.kmweather

import com.thelonelyastronaut.kmweather.di.commonModule
import com.thelonelyastronaut.kmweather.repository.network.INetworkProvider
import com.thelonelyastronaut.kmweather.utils.ILogger
import com.thelonelyastronaut.kmweather.utils.Logger
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val jsDI = DI {
    import(commonModule)
    bind<ILogger>() with singleton { Logger }
}

object DIContainerJS {
    private val kodein = DIContainer(jsDI)
    private val api: INetworkProvider by kodein.instance<INetworkProvider>()

    fun fetchWeather() = api.fetchData()
}