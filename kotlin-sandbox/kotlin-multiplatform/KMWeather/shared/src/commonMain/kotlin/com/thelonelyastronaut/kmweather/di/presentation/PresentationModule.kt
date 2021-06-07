package com.thelonelyastronaut.kmweather.di.presentation

import com.thelonelyastronaut.kmweather.domain.usecase.base.UseCase
import com.thelonelyastronaut.kmweather.presentation.WeatherForecastViewModel
import com.thelonelyastronaut.kmweather.presentation.WeatherForecastViewModelImpl
import com.thelonelyastronaut.kmweather.declarations.Weather
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val presentationModule = DI.Module("PresentationModule") {
    bind<WeatherForecastViewModel>() with provider {
        WeatherForecastViewModelImpl(instance<UseCase<String, List<Weather>>>())
    }
}