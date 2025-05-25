package com.devflowteam.data.repository

import android.database.sqlite.SQLiteFullException
import com.devflowteam.data.local.room.ArticleDao
import com.devflowteam.data.util.toDomain
import com.devflowteam.data.util.toEntity
import com.devflowteam.domain.model.Article
import com.devflowteam.domain.repository.ArticleRepository
import com.devflowteam.domain.util.error.DataError
import com.devflowteam.domain.util.error.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val dao: ArticleDao
) : ArticleRepository {

    override suspend fun replaceOldWithNew(list: List<Article>): Result<Unit, DataError.Local> {
        return try {
            dao.replaceOldWithNew(
                list.map {
                    it.toEntity()
                }
            )
            Result.Success(Unit)
        } catch (e: SQLiteFullException) {
            Result.Error(DataError.Local.DISK_FULL)
        } catch (e: Exception) {
            Result.Error(DataError.Local.UNKNOWN)
        }
    }

    override suspend fun update(article: Article): Result<Unit, DataError.Local> {
        return try {
            dao.update(article.toEntity())
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(DataError.Local.UNKNOWN)
        }
    }

    override fun getAll(): Flow<List<Article>> {
        return dao.getAll().map { entityList ->
            entityList.map { entity ->
                entity.toDomain()
            }
        }
    }
}