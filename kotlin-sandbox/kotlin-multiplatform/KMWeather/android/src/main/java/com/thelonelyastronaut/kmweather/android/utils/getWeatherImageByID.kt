package com.thelonelyastronaut.kmweather.android.utils

import androidx.compose.ui.res.painterResource
import com.thelonelyastronaut.kmweather.android.R

fun getWeatherImageByID(id: Int): Int = when(id / 100) {
    2 -> R.drawable.rain
    3 -> R.drawable.rain
    5 -> R.drawable.rain
    6 -> R.drawable.storm
    7 -> R.drawable.cloud
    8 -> R.drawable.sun
    else -> R.drawable.cloudy
}