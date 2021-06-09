package com.thelonelyastronaut.kmweather.di

import com.thelonelyastronaut.kmweather.di.domain.domainModule
import com.thelonelyastronaut.kmweather.di.presentation.presentationModule
import com.thelonelyastronaut.kmweather.di.repository.network.networkModule
import com.thelonelyastronaut.kmweather.di.repository.database.databaseModule
import com.thelonelyastronaut.kmweather.di.repository.repositoryModule
import org.kodein.di.DI

val commonModule = DI.Module("MainModule") {
    import(domainModule)
    import(presentationModule)
    import(repositoryModule)
}

