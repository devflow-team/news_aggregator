package com.devflowteam.data.local.room

import androidx.room.TypeConverter
import com.devflowteam.data.local.room.model.CacheCategory
import com.devflowteam.data.local.room.model.CacheContent
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {

    private val moshi = Moshi.Builder().build()

    private val cacheCategoryListType = Types.newParameterizedType(List::class.java, CacheCategory::class.java)
    private val cacheContentListType = Types.newParameterizedType(List::class.java, CacheContent::class.java)

    private val cacheCategoryAdapter = moshi.adapter<List<CacheCategory>>(cacheCategoryListType)
    private val cacheContentAdapter = moshi.adapter<List<CacheContent>>(cacheContentListType)

    @TypeConverter
    fun fromCacheCategoryList(list: List<CacheCategory>): String =
        cacheCategoryAdapter.toJson(list)

    @TypeConverter
    fun toCacheCategoryList(data: String): List<CacheCategory> =
        cacheCategoryAdapter.fromJson(data) ?: emptyList()

    @TypeConverter
    fun fromCacheContentList(list: List<CacheContent>): String =
        cacheContentAdapter.toJson(list)

    @TypeConverter
    fun toCacheContentList(data: String): List<CacheContent> =
        cacheContentAdapter.fromJson(data) ?: emptyList()
}