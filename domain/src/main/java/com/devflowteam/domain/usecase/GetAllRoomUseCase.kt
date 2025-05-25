package com.devflowteam.domain.usecase

import com.devflowteam.domain.repository.ArticleRepository

class GetAllRoomUseCase(
    private val repository: ArticleRepository
) {
    operator fun invoke() = repository.getAll()
}