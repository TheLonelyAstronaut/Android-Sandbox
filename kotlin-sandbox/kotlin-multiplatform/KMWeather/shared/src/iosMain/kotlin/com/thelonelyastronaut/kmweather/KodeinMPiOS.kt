package com.thelonelyastronaut.kmweather

import com.thelonelyastronaut.kmweather.di.mainModule
import com.thelonelyastronaut.kmweather.network.INetworkProvider
import org.kodein.di.DI
import org.kodein.di.instance

val iOSDI = DI {
    import(mainModule)
}

class KodeinMPiOS {
    private val kodein = KodeinMP(iOSDI)
    private val api: INetworkProvider by kodein.instance<INetworkProvider>()

    fun fetchWeather() = api.fetchData()
}