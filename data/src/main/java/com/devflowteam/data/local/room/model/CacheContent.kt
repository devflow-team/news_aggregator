package com.devflowteam.data.local.room.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CacheContent(
    val type: String? = null,
    val width: String? = null,
    val url: String,
    val credit: CacheCredit? = null
)