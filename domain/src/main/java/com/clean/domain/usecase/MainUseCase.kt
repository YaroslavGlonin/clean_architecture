package com.clean.domain.usecase

import com.clean.domain.model.Fact
import com.clean.domain.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MainUseCase(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val mainRepository: MainRepository
) {
    suspend fun execute():Fact{
        return withContext(coroutineDispatcher){
            mainRepository.get()
        }
    }
}