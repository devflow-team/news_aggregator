package com.devflowteam.data.local.room.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CacheCredit(
    val scheme: String? = null,
    val value: String
)
