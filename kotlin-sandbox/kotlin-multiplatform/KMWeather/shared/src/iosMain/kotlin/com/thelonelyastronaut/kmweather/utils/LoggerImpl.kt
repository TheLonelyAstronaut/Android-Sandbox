package com.thelonelyastronaut.kmweather.utils

object LoggerImpl: Logger {
    override fun log(data: Any) {
        print(data)
    }

    override fun error(data: Any) {
        log("Error: $data")
    }
}