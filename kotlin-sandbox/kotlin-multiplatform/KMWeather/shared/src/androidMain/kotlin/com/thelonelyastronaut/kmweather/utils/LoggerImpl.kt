package com.thelonelyastronaut.kmweather.utils

import android.util.Log

object LoggerImpl: Logger {
    private val TAG = "KMWEATHER_TAG"

    override fun log(data: Any) {
        Log.d(TAG, data.toString())
    }

    override fun error(data: Any) {
        Log.e(TAG, data.toString())
    }
}