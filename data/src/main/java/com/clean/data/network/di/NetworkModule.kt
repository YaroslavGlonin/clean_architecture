package com.clean.data.network.di

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import com.clean.data.BuildConfig
import com.clean.data.network.api.NetworkApi
import com.clean.data.network.interceptor.ErrorInterceptor
import com.clean.data.repository.MainRepositoryImpl
import com.clean.domain.repository.MainRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    val gson = GsonBuilder()
        .setLenient()
        .serializeNulls()
        .create()

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<ErrorInterceptor>())
            .build()
    }

    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.BASIC
            }
        }
    }

    single<ErrorInterceptor> { ErrorInterceptor() }
    single<NetworkApi> { get<Retrofit>().create(NetworkApi::class.java) }
    single <MainRepository>{MainRepositoryImpl(networkApi = get())}
}