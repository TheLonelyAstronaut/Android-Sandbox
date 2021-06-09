package com.thelonelyastronaut.kmweather.android.utils

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDate(shift: Int): String {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DATE, shift)
    val formatter = SimpleDateFormat("dd MMMM", Locale.ENGLISH)
    return formatter.format(calendar.time)
}