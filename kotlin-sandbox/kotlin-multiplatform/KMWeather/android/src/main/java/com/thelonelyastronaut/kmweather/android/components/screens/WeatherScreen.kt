package com.thelonelyastronaut.kmweather.android.components.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.thelonelyastronaut.kmweather.android.components.text.CustomTextInput
import com.thelonelyastronaut.kmweather.android.components.views.BackgroundView
import com.thelonelyastronaut.kmweather.android.components.views.CenterColumnView
import com.thelonelyastronaut.kmweather.android.components.views.WeatherView
import com.thelonelyastronaut.kmweather.declarations.Weather

@Composable
fun WeatherScreen(
    city: MutableState<String>,
    weather: MutableState<List<Weather>>,
    isLoading: MutableState<Boolean>,
    setCity: (String) -> Unit
) {
    Scaffold {
        BackgroundView {
            CenterColumnView {
                CustomTextInput(
                    value = city,
                    onValueChange = setCity
                )
                if (isLoading.value) {
                    CenterColumnView {
                        CircularProgressIndicator()
                    }
                } else {
                    LazyColumn {
                        items(weather.value) {
                            WeatherView(
                                weather = it,
                                index = weather.value.indexOf(it)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.fillMaxSize())
            }
        }
    }
}