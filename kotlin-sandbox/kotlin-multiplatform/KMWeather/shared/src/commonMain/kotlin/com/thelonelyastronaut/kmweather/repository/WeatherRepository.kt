package com.thelonelyastronaut.kmweather.repository

import com.thelonelyastronaut.kmweather.declarations.Weather

interface WeatherRepository {
    suspend fun getWeatherByCityName(name: String): List<Weather>
}