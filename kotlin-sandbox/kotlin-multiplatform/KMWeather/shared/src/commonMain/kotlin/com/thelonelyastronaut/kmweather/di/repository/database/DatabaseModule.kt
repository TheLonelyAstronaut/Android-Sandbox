package com.thelonelyastronaut.kmweather.di.repository.database

import com.thelonelyastronaut.kmweather.di.repository.database.entities.weatherEntityModule
import org.kodein.di.DI

val databaseModule = DI.Module("Database") {
    import(weatherEntityModule)
}