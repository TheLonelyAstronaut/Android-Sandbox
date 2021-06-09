package com.thelonelyastronaut.kmweather.di.repository.database

import com.thelonelyastronaut.kmweather.di.repository.database.dao.DAOModule
import com.thelonelyastronaut.kmweather.di.repository.database.entities.entityModule
import com.thelonelyastronaut.kmweather.repository.database.WeatherDatabase
import com.thelonelyastronaut.kmweather.repository.database.WeatherDatabaseImpl
import com.thelonelyastronaut.kmweather.repository.database.dao.WeatherDAO
import com.thelonelyastronaut.kmweather.utils.Logger
import com.thelonelyastronaut.kmweather.utils.database.SharedDatabase
import com.thelonelyastronaut.kmweather.utils.database.SharedDatabaseImpl
import com.thelonelyastronaut.kmweather.utils.database.provideDBDriver
import org.kodein.di.*

val databaseModule = DI.Module("Database") {
    import(entityModule)
    import(DAOModule)

    bind<SharedDatabase>() with eagerSingleton { SharedDatabaseImpl(::provideDBDriver, instance<Logger>()) }
    bind<WeatherDatabase>() with singleton {
        WeatherDatabaseImpl(instance<SharedDatabase>(), instance<WeatherDAO>())
    }
}
