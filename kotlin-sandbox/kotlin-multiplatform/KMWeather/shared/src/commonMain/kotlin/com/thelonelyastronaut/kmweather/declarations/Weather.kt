package com.thelonelyastronaut.kmweather.declarations

interface Weather {
    val dt: Int
    val sunrise: Int
    val sunset: Int
    val temperature: Temperature
    val feelsLike: Temperature
    val pressure: Double
    val humidity: Double
    val weather: List<WeatherDescription>
}