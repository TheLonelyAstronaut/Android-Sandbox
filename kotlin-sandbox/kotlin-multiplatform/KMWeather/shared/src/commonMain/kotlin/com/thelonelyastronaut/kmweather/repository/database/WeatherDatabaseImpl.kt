package com.thelonelyastronaut.kmweather.repository.database

import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.repository.database.dao.WeatherDAO
import com.thelonelyastronaut.kmweather.utils.database.SharedDatabase

class WeatherDatabaseImpl(
    private val database: SharedDatabase,
    private val weatherDAO: WeatherDAO
): WeatherDatabase {
    override suspend fun getWeatherByCity(city: String): List<Weather> {
        return database {
            weatherDAO.getWeatherByCity(city, it.weatherQueries)
        }
    }

    override suspend fun setWeatherByCity(city: String, weather: List<Weather>) {
        return database {
            weatherDAO.setWeatherByCity(city, weather, it.weatherQueries)
        }
    }
}