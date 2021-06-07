package com.thelonelyastronaut.kmweather.utils.database

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

lateinit var appContext: Context

actual suspend fun provideDBDriver(schema: SqlDriver.Schema): SqlDriver {
    return AndroidSqliteDriver(schema, appContext, "test.db")
}