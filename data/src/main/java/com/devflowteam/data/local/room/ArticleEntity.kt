package com.devflowteam.data.local.room

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.devflowteam.data.local.room.model.CacheCategory
import com.devflowteam.data.local.room.model.CacheContent

@Entity(indices = [Index(value = ["guid"], unique = true), Index(value = ["isFavorite"])])
data class ArticleEntity(
    val createdAt: Long,
    val isFavorite: Boolean,

    val title: String,
    val link: String,
    val description: String,
    val categories: List<CacheCategory>,
    val pubDate: String,
    val contents: List<CacheContent>,
    val dcCreator: String,
    val dcDate: String,

    @PrimaryKey
    val guid: String
)