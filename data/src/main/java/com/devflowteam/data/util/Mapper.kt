package com.devflowteam.data.util

import com.devflowteam.data.local.room.ArticleEntity
import com.devflowteam.data.local.room.model.CacheCategory
import com.devflowteam.data.local.room.model.CacheContent
import com.devflowteam.data.local.room.model.CacheCredit
import com.devflowteam.data.remote.rss.dto.CategoryDto
import com.devflowteam.data.remote.rss.dto.ContentDto
import com.devflowteam.data.remote.rss.dto.CreditDto
import com.devflowteam.data.remote.rss.dto.ItemDto
import com.devflowteam.domain.model.Article
import com.devflowteam.domain.model.Category
import com.devflowteam.domain.model.Content
import com.devflowteam.domain.model.Credit

fun ArticleEntity.toDomain() = Article(
    createdAt = createdAt,
    isFavorite = isFavorite,
    title = title,
    link = link,
    description = description,
    categories = categories.map { it.toDomain() },
    pubDate = pubDate,
    guid = guid,
    contents = contents.map { it.toDomain() },
    dcCreator = dcCreator,
    dcDate = dcDate
)

fun Article.toEntity() = ArticleEntity(
    createdAt = createdAt,
    isFavorite = isFavorite,
    title = title,
    link = link,
    description = description,
    categories = categories.map { it.toData() },
    pubDate = pubDate,
    guid = guid,
    contents = contents.map { it.toData() },
    dcCreator = dcCreator,
    dcDate = dcDate
)

fun Category.toData() = CacheCategory(
    domain = domain,
    value = value
)

fun CacheCategory.toDomain() = Category(
    domain = domain,
    value = value
)

fun Content.toData() = CacheContent(
    type = type,
    width = width,
    url = url,
    credit = credit?.toData()
)

fun CacheContent.toDomain() = Content(
    type = type,
    width = width,
    url = url,
    credit = credit?.toDomain()
)

fun Credit.toData() = CacheCredit(
    scheme = scheme,
    value = value
)

fun CacheCredit.toDomain() = Credit(
    scheme = scheme,
    value = value
)

fun ItemDto.toDomain() = Article(
    createdAt = System.currentTimeMillis(),
    isFavorite = false,
    title = title,
    link = link,
    description = description,
    categories = categories.map { it.toDomain() },
    pubDate = pubDate,
    guid = guid,
    contents = contents.map { it.toDomain() },
    dcCreator = dcCreator,
    dcDate = dcDate
)

fun CategoryDto.toDomain() = Category(
    domain = domain,
    value = value
)

fun ContentDto.toDomain() = Content(
    type = type,
    width = width,
    url = url,
    credit = credit?.toDomain()
)

fun CreditDto.toDomain() = Credit(
    scheme = scheme,
    value = value
)