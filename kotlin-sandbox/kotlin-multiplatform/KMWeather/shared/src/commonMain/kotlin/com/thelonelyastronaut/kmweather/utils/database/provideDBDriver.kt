package com.thelonelyastronaut.kmweather.utils.database

import com.squareup.sqldelight.db.SqlDriver

expect suspend fun provideDBDriver(schema: SqlDriver.Schema): SqlDriver