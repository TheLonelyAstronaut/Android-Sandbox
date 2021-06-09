package com.thelonelyastronaut.kmweather.di.repository.database.entities

import com.thelonelyastronaut.kmweather.repository.database.entities.WeatherEntityImpl
import com.thelonelyastronaut.kmweather.declarations.Weather
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.factory

val entityModule = DI.Module("WeatherEntity") {
    bind<Weather>() with factory { params: WeatherParameters ->
        WeatherEntityImpl(
            params.dt,
            params.sunrise,
            params.sunset,
            params.temperature,
            params.feelsLike,
            params.pressure,
            params.humidity,
            params.weather
        )
    }
}