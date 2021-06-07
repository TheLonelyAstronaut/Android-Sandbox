package com.thelonelyastronaut.kmweather.repository.network.api

import com.thelonelyastronaut.kmweather.utils.Logger

class APIServiceImpl(private val _logger: Logger): APIService {
    override fun fetchData(): String {
        _logger.log("Well, nice")
        return "TEST DI"
    }
}
