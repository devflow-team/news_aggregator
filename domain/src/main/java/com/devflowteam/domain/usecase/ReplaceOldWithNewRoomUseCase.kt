package com.devflowteam.domain.usecase

import com.devflowteam.domain.model.Article
import com.devflowteam.domain.repository.ArticleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ReplaceOldWithNewRoomUseCase(
    private val repository: ArticleRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke(new: List<Article>) = withContext(dispatcher) {
        repository.replaceOldWithNew(new)
    }
}