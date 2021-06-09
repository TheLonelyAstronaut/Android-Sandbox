package com.thelonelyastronaut.kmweather.di.domain

import com.thelonelyastronaut.kmweather.di.domain.usecase.useCaseModule
import org.kodein.di.DI

val domainModule = DI.Module("Domain") {
    import(useCaseModule)
}