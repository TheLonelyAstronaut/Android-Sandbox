package com.thelonelyastronaut.kmweather.utils.database

import com.squareup.sqldelight.db.SqlDriver
import com.thelonelyastronaut.kmweather.WeatherDatabaseGenerated

fun createDatabase(driver: SqlDriver): WeatherDatabaseGenerated {
    return WeatherDatabaseGenerated(driver)
}