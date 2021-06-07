package com.thelonelyastronaut.kmweather.utils.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual suspend fun provideDBDriver(schema: SqlDriver.Schema): SqlDriver {
    return NativeSqliteDriver(schema, "test.db")
}