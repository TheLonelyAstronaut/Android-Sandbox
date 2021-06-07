package com.thelonelyastronaut.kmweather.utils.database

import com.thelonelyastronaut.kmweather.WeatherDatabaseGenerated

interface SharedDatabase {
    suspend fun initDatabase()
    suspend operator fun <R> invoke(block: suspend (WeatherDatabaseGenerated) -> R): R
}