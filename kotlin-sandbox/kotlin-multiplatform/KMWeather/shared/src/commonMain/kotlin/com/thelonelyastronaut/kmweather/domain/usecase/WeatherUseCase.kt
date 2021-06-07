package com.thelonelyastronaut.kmweather.domain.usecase

import com.thelonelyastronaut.kmweather.domain.usecase.base.UseCase
import com.thelonelyastronaut.kmweather.repository.database.entities.WeatherEntityImpl
import com.thelonelyastronaut.kmweather.types.Weather
import com.thelonelyastronaut.kmweather.utils.Logger

class WeatherUseCase<String>(
    private val _logger: Logger
): UseCase<String, List<Weather>> {
    override suspend fun execute(request: String?): List<Weather> {
        val list = mutableListOf<Weather>()

        request?.let {
            _logger.log(request)

            val test = WeatherEntityImpl(2.0)
            list.add(test)
            list.add(test)
            list.add(test)
        }

        return list
    }
}