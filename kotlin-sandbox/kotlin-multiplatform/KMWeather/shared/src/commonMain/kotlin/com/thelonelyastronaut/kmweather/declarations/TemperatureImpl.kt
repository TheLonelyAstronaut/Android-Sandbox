package com.thelonelyastronaut.kmweather.declarations

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TemperatureImpl(
    override val day: Double,
    @SerialName("min")
    override val min: Double? = null,
    @SerialName("max")
    override val max: Double? = null,
    override val night: Double,
    @SerialName("eve")
    override val evening: Double,
    @SerialName("morn")
    override val morning: Double,
): Temperature {}