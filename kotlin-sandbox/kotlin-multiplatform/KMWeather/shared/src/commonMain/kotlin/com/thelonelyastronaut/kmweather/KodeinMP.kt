package com.thelonelyastronaut.kmweather

import com.thelonelyastronaut.kmweather.di.mainModule
import com.thelonelyastronaut.kmweather.network.INetworkProvider
import org.kodein.di.*

open class KodeinMP(override val di: DI): DIAware {
    private val api: INetworkProvider by instance<INetworkProvider>()

    fun testDI() = api.fetchData()
}

