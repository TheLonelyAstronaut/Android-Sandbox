package com.thelonelyastronaut.kmweather.repository.network.api

import com.thelonelyastronaut.kmweather.declarations.Weather

interface WeatherAPIService {
    fun getAPIEndpoint(city: String): String
    suspend fun fetchData(city: String): List<Weather>?
}