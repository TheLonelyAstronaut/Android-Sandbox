package com.thelonelyastronaut.kmweather.repository.network.api

import com.thelonelyastronaut.kmweather.repository.database.entities.WeatherEntityImpl
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse (
    val list: List<WeatherEntityImpl>
) {}