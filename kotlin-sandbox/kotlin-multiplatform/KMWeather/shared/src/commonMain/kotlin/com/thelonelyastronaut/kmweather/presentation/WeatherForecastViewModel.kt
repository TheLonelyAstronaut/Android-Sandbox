package com.thelonelyastronaut.kmweather.presentation

import com.badoo.reaktive.disposable.Disposable
import com.badoo.reaktive.observable.Observable
import com.thelonelyastronaut.kmweather.declarations.Weather

interface WeatherForecastViewModel {
    val forecast: Observable<List<Weather>>
    val isLoading: Observable<Boolean>
    fun getWeatherByCityName(city: String)
    fun <T> subscribe(
        observable: Observable<T>,
        onSubscribe: ((Disposable) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null,
        onComplete: (() -> Unit)? = null,
        onNext: ((T) -> Unit)? = null
    )
}