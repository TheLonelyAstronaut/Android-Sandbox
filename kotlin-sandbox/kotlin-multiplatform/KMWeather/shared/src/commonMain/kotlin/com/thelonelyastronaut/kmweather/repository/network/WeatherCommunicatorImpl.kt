package com.thelonelyastronaut.kmweather.repository.network

import com.thelonelyastronaut.kmweather.repository.network.api.WeatherAPIService
import com.thelonelyastronaut.kmweather.declarations.Weather

class WeatherCommunicatorImpl(
    private val api: WeatherAPIService
): WeatherCommunicator {
    override suspend fun getCityWeatherFromAPI(city: String): List<Weather>? = api.fetchData(city)
}