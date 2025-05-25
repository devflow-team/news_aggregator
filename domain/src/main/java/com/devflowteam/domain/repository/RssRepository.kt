package com.devflowteam.domain.repository

import com.devflowteam.domain.model.Article
import com.devflowteam.domain.util.error.DataError
import com.devflowteam.domain.util.error.Result

interface RssRepository {

    suspend fun getAll(): Result<List<Article>, DataError.Network>
}