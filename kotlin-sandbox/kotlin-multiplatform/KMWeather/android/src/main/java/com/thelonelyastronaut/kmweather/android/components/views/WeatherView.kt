package com.thelonelyastronaut.kmweather.android.components.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.thelonelyastronaut.kmweather.android.utils.getWeatherImageByID
import com.thelonelyastronaut.kmweather.declarations.Weather
import compose.icons.AllIcons
import compose.icons.WeatherIcons
import compose.icons.weathericons.Cloud
import compose.icons.weathericons.Hot

@Composable
fun WeatherView(weather: Weather) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(getWeatherImageByID(
                    if(weather.weather.isNotEmpty()) weather.weather[0].id
                    else 0
                )),
                contentDescription = "",
                modifier = Modifier
                    .size(32.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Tuesday")
                Text("${weather.temperature.max} °C")
            }
        }
    }
}