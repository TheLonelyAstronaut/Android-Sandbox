package com.thelonelyastronaut.kmweather.di.repository.database.entities

import com.thelonelyastronaut.kmweather.repository.database.entities.WeatherEntity
import com.thelonelyastronaut.kmweather.repository.database.entities.WeatherEntityImpl
import com.thelonelyastronaut.kmweather.types.Weather
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.factory

val weatherEntityModule = DI.Module("WeatherEntity") {
    bind<Weather>() with factory { averageTemperature: Double -> WeatherEntityImpl(averageTemperature) }
}