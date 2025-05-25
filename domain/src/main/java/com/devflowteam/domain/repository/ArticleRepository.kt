package com.devflowteam.domain.repository

import com.devflowteam.domain.model.Article
import com.devflowteam.domain.util.error.DataError
import com.devflowteam.domain.util.error.Result
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    suspend fun replaceOldWithNew(list: List<Article>): Result<Unit, DataError.Local>

    suspend fun update(article: Article): Result<Unit, DataError.Local>

    fun getAll(): Flow<List<Article>>
}