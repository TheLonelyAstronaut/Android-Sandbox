package com.thelonelyastronaut.kmweather.types

import kotlinx.serialization.Serializable

interface Weather {
    val averageTemperature: Double
}