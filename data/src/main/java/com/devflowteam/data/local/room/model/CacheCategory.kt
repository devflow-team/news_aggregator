package com.devflowteam.data.local.room.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CacheCategory(
    val domain: String,
    val value: String
)