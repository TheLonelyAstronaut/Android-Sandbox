package com.thelonelyastronaut.kmweather.repository.network.api

import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.utils.Logger
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class WeatherAPIServiceImpl(
    private val _logger: Logger,
    private val httpClient: HttpClient
): WeatherAPIService {
    private val _count = 5
    private val _apiKey = "886705b4c1182eb1c69f28eb8c520e20"

    override suspend fun fetchData(city: String): List<Weather>? {
        val endpoint = getAPIEndpoint(city)

        return try {
            val json = httpClient.get<String>(endpoint)

            val response = Json {
                ignoreUnknownKeys = true
                isLenient = true
            } .decodeFromString(WeatherResponse.serializer(), json)

            response.list
        } catch (cause: Throwable) {
            _logger.log(cause.stackTraceToString())
            null
        }
    }

    override fun getAPIEndpoint(city: String): String {
        return "https://api.openweathermap.org/data/2.5/forecast/daily?q=${city}&cnt=${_count}&units=metric&appid=${_apiKey}"
    }
}
