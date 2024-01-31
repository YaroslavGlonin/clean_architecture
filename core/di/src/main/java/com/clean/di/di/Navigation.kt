package com.clean.di.di

import com.clean.di.api.AppRouterImpl
import com.clean.feature_first.api.FeatureFirstApiImpl
import com.clean.feature_first_api.api.FeatureFirstApi
import com.clean.feature_second.api.FeatureSecondApiImpl
import com.clean.feature_second_api.api.FeatureSecondApi
import com.clean.navigation.api.AppRouter
import org.koin.dsl.module

val navigationModule = module {
    single<AppRouter>{AppRouterImpl()}
    single <FeatureFirstApi> {FeatureFirstApiImpl()}
    single <FeatureSecondApi>{FeatureSecondApiImpl()}
}