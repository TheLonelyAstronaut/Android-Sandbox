package com.thelonelyastronaut.kmweather

import com.thelonelyastronaut.kmweather.di.commonModule
import com.thelonelyastronaut.kmweather.utils.Logger
import com.thelonelyastronaut.kmweather.utils.LoggerImpl
import com.thelonelyastronaut.kmweather.utils.database.SharedDatabase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

internal val jsDI = DI {
    import(commonModule)
    bind<Logger>() with singleton { LoggerImpl }
}

object DIContainerJS: DIContainer(jsDI) {
    suspend fun initDB() {
        val database: SharedDatabase by jsDI.instance<SharedDatabase>()

        database.initDatabase()
    }
}