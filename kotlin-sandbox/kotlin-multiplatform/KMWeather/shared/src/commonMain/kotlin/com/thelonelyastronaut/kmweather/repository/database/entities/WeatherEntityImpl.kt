package com.thelonelyastronaut.kmweather.repository.database.entities

import com.thelonelyastronaut.kmweather.types.Weather
import kotlinx.serialization.Serializable

@Serializable
data class WeatherEntityImpl(
    override val averageTemperature: Double
): WeatherEntity {}