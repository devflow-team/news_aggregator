package com.devflowteam.domain.model

data class Article(
    val createdAt: Long,
    val isFavorite: Boolean,
    val title: String,
    val link: String,
    val description: String,
    val categories: List<Category>,
    val pubDate: String,
    val guid: String,
    val contents: List<Content>,
    val dcCreator: String,
    val dcDate: String
)