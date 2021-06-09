package com.thelonelyastronaut.kmweather.utils.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.sqljs.initSqlDriver
import kotlinx.coroutines.await

actual suspend fun provideDBDriver(schema: SqlDriver.Schema): SqlDriver {
    return initSqlDriver(schema).await()
}