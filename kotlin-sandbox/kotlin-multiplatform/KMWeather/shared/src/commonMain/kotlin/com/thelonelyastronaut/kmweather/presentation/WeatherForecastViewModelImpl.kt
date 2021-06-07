package com.thelonelyastronaut.kmweather.presentation

import com.badoo.reaktive.coroutinesinterop.singleFromCoroutine
import com.badoo.reaktive.disposable.Disposable
import com.badoo.reaktive.observable.*
import com.badoo.reaktive.scheduler.ioScheduler
import com.badoo.reaktive.scheduler.mainScheduler
import com.badoo.reaktive.single.subscribeOn
import com.badoo.reaktive.subject.publish.PublishSubject
import com.thelonelyastronaut.kmweather.presentation.base.ViewModelBinding
import com.thelonelyastronaut.kmweather.domain.usecase.base.UseCase
import com.thelonelyastronaut.kmweather.declarations.Weather

class WeatherForecastViewModelImpl(
    private val useCase: UseCase<String, List<Weather>>
): WeatherForecastViewModel, ViewModelBinding() {
    override val forecast: Observable<List<Weather>>
    override val isLoading: Observable<Boolean>

    private val loadingSubject = PublishSubject<Boolean>()
    private val forecastSubject = PublishSubject<String>()

    init {
        isLoading = loadingSubject

        forecast = forecastSubject
            .threadLocal()
            //.debounce(300, mainScheduler)
            .doOnBeforeNext { loadingSubject.onNext(true)}
            .distinctUntilChanged()
            .flatMapSingle { request ->
                singleFromCoroutine { useCase.execute(request) }
                    .subscribeOn(ioScheduler)
            }
            .observeOn(mainScheduler)
            .doOnBeforeNext { loadingSubject.onNext(false) }
            .map { it }
    }

    override fun <T> subscribe(
        observable: Observable<T>,
        onSubscribe: ((Disposable) -> Unit)?,
        onError: ((Throwable) -> Unit)?,
        onComplete: (() -> Unit)?,
        onNext: ((T) -> Unit)?
    ) = subscribe(observable, true, onSubscribe, onError, onComplete, onNext)

    override fun getWeatherByCityName(city: String) {
        forecastSubject.onNext(city)
    }
}