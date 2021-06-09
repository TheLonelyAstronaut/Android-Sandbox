package com.thelonelyastronaut.kmweather.domain.usecase.base

interface UseCase<R, T> {
    suspend fun execute(request: R?): T
}