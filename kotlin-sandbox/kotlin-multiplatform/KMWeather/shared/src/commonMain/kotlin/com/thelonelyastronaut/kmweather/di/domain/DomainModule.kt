package com.thelonelyastronaut.kmweather.di.domain

import com.thelonelyastronaut.kmweather.di.domain.usecase.useCaseModule
import com.thelonelyastronaut.kmweather.domain.WeatherForecastViewModel
import com.thelonelyastronaut.kmweather.domain.WeatherForecastViewModelImpl
import com.thelonelyastronaut.kmweather.domain.usecase.base.UseCase
import com.thelonelyastronaut.kmweather.types.Weather
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val domainModule = DI.Module("Domain") {
    import(useCaseModule)

    bind<WeatherForecastViewModel>() with provider {
        WeatherForecastViewModelImpl(instance<UseCase<String, List<Weather>>>())
    }
}