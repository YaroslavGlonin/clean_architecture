package com.clean.domain.repository

import com.clean.domain.model.Fact
import com.clean.domain.state.State

interface MainRepository {

    suspend fun get(): Fact
}