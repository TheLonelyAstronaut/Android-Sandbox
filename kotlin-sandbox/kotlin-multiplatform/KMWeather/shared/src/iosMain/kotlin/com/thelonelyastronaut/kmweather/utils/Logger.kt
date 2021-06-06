package com.thelonelyastronaut.kmweather.utils

object Logger: ILogger {
    override fun log(data: Any) {
        print(data)
    }

    override fun error(data: Any) {
        log("Error: $data")
    }
}