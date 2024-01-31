package com.clean.clean_architecture.app

import android.app.Application
import com.clean.data.network.di.networkModule
import com.clean.di.di.domainModule
import com.clean.di.di.navigationModule
import com.clean.feature_second.di.secondFeature
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App )
            modules(
                navigationModule,
                networkModule,
                domainModule,
                secondFeature
            )

        }
    }
}