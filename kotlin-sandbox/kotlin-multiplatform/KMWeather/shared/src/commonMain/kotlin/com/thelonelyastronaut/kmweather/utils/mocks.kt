package com.thelonelyastronaut.kmweather.utils

import com.thelonelyastronaut.kmweather.declarations.TemperatureImpl
import com.thelonelyastronaut.kmweather.repository.database.entities.WeatherEntityImpl

val mockTemperature = TemperatureImpl(
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0
)

val mockWeather = WeatherEntityImpl(
    0,
    0,
    0,
    mockTemperature,
    mockTemperature,
    0.0,
    0.0,
    listOf()
)