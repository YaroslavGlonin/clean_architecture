package com.clean.di.di

import com.clean.domain.usecase.MainUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    factory<MainUseCase> { MainUseCase(coroutineDispatcher = Dispatchers.IO, mainRepository = get()) }
}
