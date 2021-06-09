package com.thelonelyastronaut.kmweather.di.repository.database.entities

import com.thelonelyastronaut.kmweather.declarations.TemperatureImpl
import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.declarations.WeatherDescriptionImpl


data class WeatherParameters(
    override val dt: Int,
    override val sunrise: Int,
    override val sunset: Int,
    override val temperature: TemperatureImpl,
    override val feelsLike: TemperatureImpl,
    override val pressure: Double,
    override val humidity: Double,
    override val weather: List<WeatherDescriptionImpl>
): Weather {}