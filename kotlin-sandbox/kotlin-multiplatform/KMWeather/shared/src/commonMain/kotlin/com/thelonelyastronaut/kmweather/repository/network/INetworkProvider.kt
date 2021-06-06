package com.thelonelyastronaut.kmweather.repository.network

interface INetworkProvider {
    fun fetchData(): String
}