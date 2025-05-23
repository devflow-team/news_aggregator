package com.devflowteam.data.remote.rss

import com.devflowteam.data.remote.rss.dto.RssDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RssFeed {
    @GET("/{query}/rss")
    suspend fun getRss(
        @Path("query") query: String = "international"
    ): RssDto
}