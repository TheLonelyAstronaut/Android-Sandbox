package com.thelonelyastronaut.kmweather.di.domain.usecase

import com.thelonelyastronaut.kmweather.domain.usecase.WeatherUseCase
import com.thelonelyastronaut.kmweather.domain.usecase.base.UseCase
import com.thelonelyastronaut.kmweather.repository.WeatherRepository
import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.utils.Logger
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val useCaseModule = DI.Module("UseCase") {
    bind<UseCase<String, List<Weather>>>() with singleton {
        WeatherUseCase<String>(instance<Logger>(), instance<WeatherRepository>())
    }
}