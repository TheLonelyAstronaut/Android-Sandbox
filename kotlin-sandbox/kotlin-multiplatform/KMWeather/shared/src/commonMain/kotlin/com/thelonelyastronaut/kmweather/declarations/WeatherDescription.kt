package com.thelonelyastronaut.kmweather.declarations

interface WeatherDescription {
    val id: Int
    val main: String
    val description: String
    val icon: String
}