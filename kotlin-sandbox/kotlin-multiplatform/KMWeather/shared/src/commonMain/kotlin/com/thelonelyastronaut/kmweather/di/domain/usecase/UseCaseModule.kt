package com.thelonelyastronaut.kmweather.di.domain.usecase

import com.thelonelyastronaut.kmweather.domain.usecase.WeatherUseCase
import com.thelonelyastronaut.kmweather.domain.usecase.base.UseCase
import com.thelonelyastronaut.kmweather.repository.database.entities.WeatherEntityImpl
import com.thelonelyastronaut.kmweather.types.Weather
import com.thelonelyastronaut.kmweather.utils.Logger
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val useCaseModule = DI.Module("UseCase") {
    bind<UseCase<String, List<Weather>>>() with singleton { WeatherUseCase<String>(instance<Logger>()) }
}