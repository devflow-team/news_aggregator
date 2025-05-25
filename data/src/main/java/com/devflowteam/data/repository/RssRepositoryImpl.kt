package com.devflowteam.data.repository

import com.devflowteam.data.remote.rss.RssFeed
import com.devflowteam.data.util.toDomain
import com.devflowteam.domain.model.Article
import com.devflowteam.domain.repository.RssRepository
import com.devflowteam.domain.util.error.DataError
import com.devflowteam.domain.util.error.Result
import retrofit2.Retrofit
import java.io.IOException
import javax.inject.Inject

class RssRepositoryImpl @Inject constructor(
    private val retrofit: Retrofit
) : RssRepository {

    override suspend fun getAll(): Result<List<Article>, DataError.Network> {
        return try {
            val channel = retrofit
                .create(RssFeed::class.java)
                .getRss()
                .channel
            val list = channel.items.map { it.toDomain() }

            Result.Success(list)
        } catch (e: IOException) {
            Result.Error(DataError.Network.NO_INTERNET)
        } catch (e: Exception) {
            Result.Error(DataError.Network.UNKNOWN)
        }
    }
}