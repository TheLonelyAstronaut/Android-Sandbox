package com.thelonelyastronaut.kmweather.data

import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    val averageTemperature: Double
) {}
