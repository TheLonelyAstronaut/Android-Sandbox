package com.thelonelyastronaut.kmweather.declarations

interface Temperature {
    val day: Double
    val min: Double?
    val max: Double?
    val night: Double
    val evening: Double
    val morning: Double
}