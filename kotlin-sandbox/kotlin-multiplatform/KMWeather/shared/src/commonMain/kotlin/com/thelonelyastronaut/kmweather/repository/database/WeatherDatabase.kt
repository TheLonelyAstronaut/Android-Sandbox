package com.thelonelyastronaut.kmweather.repository.database

import com.thelonelyastronaut.kmweather.declarations.Weather

interface WeatherDatabase {
    suspend fun getWeatherByCity(city: String): List<Weather>
    suspend fun setWeatherByCity(city: String, weather: List<Weather>)
}