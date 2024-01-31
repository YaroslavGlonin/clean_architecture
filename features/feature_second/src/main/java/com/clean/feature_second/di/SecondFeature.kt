package com.clean.feature_second.di

import com.clean.feature_second.ui.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val secondFeature = module {
    viewModel{
        SecondViewModel(
            mainUseCase = get()
        )
    }
}