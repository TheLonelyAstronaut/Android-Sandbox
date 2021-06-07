package com.thelonelyastronaut.kmweather.repository

import com.thelonelyastronaut.kmweather.repository.network.WeatherCommunicator
import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.repository.database.WeatherDatabase

class WeatherRepositoryImpl(
    private val communicator: WeatherCommunicator,
    private val database: WeatherDatabase
): WeatherRepository {
    override suspend fun getWeatherByCityName(name: String): List<Weather>{
        val weather = mutableListOf<Weather>()
        val fromAPI = communicator.getCityWeatherFromAPI(name)

        if (fromAPI != null) {
            weather.addAll(fromAPI)
            database.setWeatherByCity(name, fromAPI)
        } else {
            weather.addAll(database.getWeatherByCity(name))
        }

        return weather
    }
}