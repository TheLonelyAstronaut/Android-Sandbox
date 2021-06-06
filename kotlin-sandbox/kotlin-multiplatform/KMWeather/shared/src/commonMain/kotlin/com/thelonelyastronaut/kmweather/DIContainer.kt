package com.thelonelyastronaut.kmweather

import com.thelonelyastronaut.kmweather.repository.network.INetworkProvider
import org.kodein.di.*

class DIContainer(override val di: DI): DIAware {
    private val api: INetworkProvider by instance<INetworkProvider>()

    fun testDI() = api.fetchData()
}

