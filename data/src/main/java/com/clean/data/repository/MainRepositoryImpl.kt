package com.clean.data.repository

import com.clean.data.network.api.NetworkApi
import com.clean.domain.model.Fact
import com.clean.domain.repository.MainRepository
import com.clean.domain.state.State

class MainRepositoryImpl(
    private val networkApi: NetworkApi
): MainRepository {
    override suspend fun get(): Fact {
       return networkApi.getCatFact()
    }
}