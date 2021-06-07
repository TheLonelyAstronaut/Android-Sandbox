package com.thelonelyastronaut.kmweather.declarations

import kotlinx.serialization.Serializable

@Serializable
data class WeatherDescriptionImpl(
    override val id: Int,
    override val main: String,
    override val description: String,
    override val icon: String
): WeatherDescription {}