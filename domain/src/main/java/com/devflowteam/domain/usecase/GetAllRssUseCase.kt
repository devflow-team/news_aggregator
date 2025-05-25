package com.devflowteam.domain.usecase

import com.devflowteam.domain.repository.RssRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllRssUseCase(
    private val repository: RssRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke() = withContext(dispatcher) {
        repository.getAll()
    }
}