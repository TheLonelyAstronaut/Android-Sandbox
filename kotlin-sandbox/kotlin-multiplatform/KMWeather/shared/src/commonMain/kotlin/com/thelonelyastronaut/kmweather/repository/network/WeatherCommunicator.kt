package com.thelonelyastronaut.kmweather.repository.network

import com.thelonelyastronaut.kmweather.declarations.Weather

interface WeatherCommunicator {
    suspend fun getCityWeatherFromAPI(city: String): List<Weather>?
}