package com.thelonelyastronaut.kmweather

import com.thelonelyastronaut.kmweather.domain.WeatherForecastViewModel
import org.kodein.di.*

open class DIContainer(override val di: DI): DIAware {
    fun getWeatherForecastViewModel(): WeatherForecastViewModel {
        val viewModel: WeatherForecastViewModel by instance<WeatherForecastViewModel>()
        return viewModel
    }
}

