package com.devflowteam.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Transaction
    suspend fun replaceOldWithNew(list: List<ArticleEntity>) {
        deleteOld(list.size)
        insertAll(list)
    }

    @Query("DELETE FROM ArticleEntity WHERE guid IN ( SELECT guid FROM ArticleEntity WHERE isFavorite = 0 ORDER BY createdAt ASC LIMIT :limit )")
    suspend fun deleteOld(limit: Int)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(list: List<ArticleEntity>)

    @Update
    suspend fun update(articleEntity: ArticleEntity)

    @Query("SELECT * FROM ArticleEntity")
    fun getAll(): Flow<List<ArticleEntity>>
}