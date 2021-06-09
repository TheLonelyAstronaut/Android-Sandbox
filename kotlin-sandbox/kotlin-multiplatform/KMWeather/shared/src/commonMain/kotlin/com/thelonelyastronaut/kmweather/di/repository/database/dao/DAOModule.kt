package com.thelonelyastronaut.kmweather.di.repository.database.dao

import com.thelonelyastronaut.kmweather.WeatherQueries
import com.thelonelyastronaut.kmweather.repository.database.dao.WeatherDAO
import com.thelonelyastronaut.kmweather.repository.database.dao.WeatherDAOImpl
import com.thelonelyastronaut.kmweather.utils.Logger
import org.kodein.di.*

val DAOModule = DI.Module("DAOModule") {
    bind<WeatherDAO>() with singleton { WeatherDAOImpl(instance<Logger>()) }
}