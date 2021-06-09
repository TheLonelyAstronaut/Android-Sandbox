package com.thelonelyastronaut.kmweather.repository.database.entities

import com.thelonelyastronaut.kmweather.declarations.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherEntityImpl(
    override val dt: Int,
    override val sunrise: Int,
    override val sunset: Int,
    @SerialName("temp")
    override val temperature: TemperatureImpl,
    @SerialName("feels_like")
    override val feelsLike: TemperatureImpl,
    override val pressure: Double,
    override val humidity: Double,
    override val weather: List<WeatherDescriptionImpl>
): Weather {}