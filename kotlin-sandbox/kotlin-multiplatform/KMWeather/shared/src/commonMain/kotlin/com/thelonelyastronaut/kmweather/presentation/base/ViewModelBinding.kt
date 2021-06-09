package com.thelonelyastronaut.kmweather.presentation.base

import com.badoo.reaktive.annotations.ExperimentalReaktiveApi
import com.badoo.reaktive.disposable.Disposable
import com.badoo.reaktive.disposable.scope.DisposableScope
import com.badoo.reaktive.observable.Observable

@OptIn(ExperimentalReaktiveApi::class)
open class ViewModelBinding: DisposableScope by DisposableScope() {
    fun <T> subscribe(
        observable: Observable<T>,
        isThreadLocal: Boolean,
        onSubscribe: ((Disposable) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null,
        onComplete: (() -> Unit)? = null,
        onNext: ((T) -> Unit)? = null
    ) {
        observable.subscribeScoped(
            isThreadLocal = isThreadLocal,
            onSubscribe = onSubscribe,
            onError = onError,
            onComplete = onComplete,
            onNext = onNext
        )
    }
}