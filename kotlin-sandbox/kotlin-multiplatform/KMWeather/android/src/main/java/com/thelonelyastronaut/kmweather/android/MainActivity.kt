package com.thelonelyastronaut.kmweather.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.thelonelyastronaut.kmweather.DIContainerAndroid
import android.widget.TextView
import com.thelonelyastronaut.kmweather.presentation.WeatherForecastViewModel
import com.thelonelyastronaut.kmweather.utils.database.appContext

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: WeatherForecastViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)

        appContext = this.applicationContext
        viewModel = DIContainerAndroid.getWeatherForecastViewModel()

        testKMMModule()

        tv.text = "IS IT COMPILE?"
    }

    private fun testKMMModule() {
        viewModel.subscribe(viewModel.forecast, onNext = {
            Log.e("RESULT", it.toString())
        })

        viewModel.subscribe(viewModel.isLoading, onNext = {
            Log.e("LOADING", it.toString())
        })

        viewModel.getWeatherByCityName("Minsk")
    }
}
