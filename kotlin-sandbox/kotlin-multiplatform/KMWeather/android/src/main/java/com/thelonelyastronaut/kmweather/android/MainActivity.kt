package com.thelonelyastronaut.kmweather.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.thelonelyastronaut.kmweather.DIContainerAndroid
import com.thelonelyastronaut.kmweather.android.components.screens.WeatherScreen
import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.presentation.WeatherForecastViewModel
import com.thelonelyastronaut.kmweather.utils.database.appContext

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: WeatherForecastViewModel
    private var city = mutableStateOf("Minsk")
    private var isLoading = mutableStateOf(false)
    private var weather = mutableStateOf(listOf<Weather>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appContext = this.applicationContext
        viewModel = DIContainerAndroid.getWeatherForecastViewModel()

        setupKMMModule()
        search()

        setContent {
            WeatherScreen(
                city = city,
                weather = weather,
                isLoading = isLoading
            ) {
                city.value = it
                search()
            }
        }
    }

    private fun setupKMMModule() {
        viewModel.subscribe(viewModel.forecast, onNext = {
            weather.value = it
        })

        viewModel.subscribe(viewModel.isLoading, onNext = {
            isLoading.value = it
        })
    }

    private fun search() {
        isLoading.value = true
        viewModel.getWeatherByCityName(city.value)
    }
}
