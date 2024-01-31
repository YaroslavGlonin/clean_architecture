package com.clean.data.network.api

import com.clean.domain.model.Fact
import retrofit2.http.GET

interface NetworkApi {
    @GET("fact")
    suspend fun getCatFact() : Fact
}