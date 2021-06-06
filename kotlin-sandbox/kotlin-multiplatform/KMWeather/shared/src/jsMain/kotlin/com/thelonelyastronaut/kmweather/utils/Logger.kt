package com.thelonelyastronaut.kmweather.utils

object Logger: ILogger {
    override fun log(data: Any) {
        console.log(data)
    }

    override fun error(data: Any) {
        console.error(data)
    }
}