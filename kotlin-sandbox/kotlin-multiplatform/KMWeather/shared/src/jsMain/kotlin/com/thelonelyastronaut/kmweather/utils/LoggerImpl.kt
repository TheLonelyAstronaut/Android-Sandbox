package com.thelonelyastronaut.kmweather.utils

object LoggerImpl: Logger {
    override fun log(data: Any) {
        console.log(data)
    }

    override fun error(data: Any) {
        console.error(data)
    }
}