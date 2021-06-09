package com.thelonelyastronaut.kmweather.utils.database

import com.squareup.sqldelight.db.SqlDriver
import com.thelonelyastronaut.kmweather.WeatherDatabaseGenerated
import com.thelonelyastronaut.kmweather.utils.Logger
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SharedDatabaseImpl(
    private val driverProvider: suspend (SqlDriver.Schema) -> SqlDriver,
    private val _logger: Logger
): SharedDatabase {
    private var database: WeatherDatabaseGenerated? = null

    override suspend fun initDatabase() {
        if (database == null) {
            database = driverProvider(WeatherDatabaseGenerated.Schema).createDatabase()
        }
    }

    override suspend fun <R> invoke(block: suspend (WeatherDatabaseGenerated) -> R): R {
        initDatabase()
        return block(database!!)
    }

    private fun SqlDriver.createDatabase(): WeatherDatabaseGenerated {
        return WeatherDatabaseGenerated(this)
    }
}