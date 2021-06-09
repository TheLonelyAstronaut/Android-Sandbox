package com.thelonelyastronaut.kmweather

import com.badoo.reaktive.coroutinesinterop.singleFromCoroutine
import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.presentation.WeatherForecastViewModel
import com.thelonelyastronaut.kmweather.utils.database.SharedDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.*

open class DIContainer(override val di: DI): DIAware {

    fun getWeatherForecastViewModel(): WeatherForecastViewModel {
        val viewModel: WeatherForecastViewModel by instance<WeatherForecastViewModel>()
        return viewModel
    }
}

