package com.thelonelyastronaut.kmweather.repository.database.dao

import com.thelonelyastronaut.kmweather.WeatherQueries
import com.thelonelyastronaut.kmweather.declarations.Weather

interface WeatherDAO {
    suspend fun getWeatherByCity(city: String, queries: WeatherQueries): List<Weather>
    suspend fun setWeatherByCity(city: String, weather: List<Weather>, queries: WeatherQueries)
}