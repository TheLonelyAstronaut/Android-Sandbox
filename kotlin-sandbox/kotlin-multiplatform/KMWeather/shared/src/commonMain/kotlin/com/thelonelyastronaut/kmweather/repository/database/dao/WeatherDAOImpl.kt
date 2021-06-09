package com.thelonelyastronaut.kmweather.repository.database.dao

import com.thelonelyastronaut.kmweather.City
import com.thelonelyastronaut.kmweather.WeatherQueries
import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.repository.database.entities.WeatherEntityImpl
import com.thelonelyastronaut.kmweather.utils.Logger
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class WeatherDAOImpl(
    private val _logger: Logger
): WeatherDAO {

    override suspend fun getWeatherByCity(city: String, queries: WeatherQueries): List<Weather> {
        return queries.select(city)
            .executeAsList()
            .flatMap {
                Json.decodeFromString(
                    ListSerializer<WeatherEntityImpl>(WeatherEntityImpl.serializer()),
                    it.weather
                )
            }
    }

    override suspend fun setWeatherByCity(city: String, weather: List<Weather>, queries: WeatherQueries) {
        val json = Json.encodeToString(
            ListSerializer<WeatherEntityImpl>(WeatherEntityImpl.serializer()), weather as List<WeatherEntityImpl>
        )

        queries.insertItem(city, json)
    }
}