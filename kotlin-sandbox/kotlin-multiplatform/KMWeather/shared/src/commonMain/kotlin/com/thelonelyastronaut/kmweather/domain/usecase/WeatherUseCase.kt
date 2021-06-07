package com.thelonelyastronaut.kmweather.domain.usecase

import com.thelonelyastronaut.kmweather.domain.usecase.base.UseCase
import com.thelonelyastronaut.kmweather.repository.WeatherRepository
import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.utils.Logger

class WeatherUseCase<String>(
    private val _logger: Logger,
    private val _repository: WeatherRepository
): UseCase<String, List<Weather>> {
    override suspend fun execute(request: String?): List<Weather> {
        val list = mutableListOf<Weather>()

        request?.let {
            _logger.log(request)

            list.addAll(_repository.getWeatherByCityName(it as kotlin.String))

            // Simulating very hard work to test coroutines
            /*for(i in 1..1000000000) {
                var a = i;
                a += 2;
            }*/
        }

        return list
    }
}