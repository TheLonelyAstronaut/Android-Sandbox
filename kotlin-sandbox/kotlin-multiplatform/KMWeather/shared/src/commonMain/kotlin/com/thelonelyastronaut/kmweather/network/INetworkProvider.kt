package com.thelonelyastronaut.kmweather.network

interface INetworkProvider {
    fun fetchData(): String
}