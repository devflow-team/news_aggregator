package com.example.newsaggregator.ui

import com.devflowteam.domain.model.Article
import com.devflowteam.domain.model.Category
import com.devflowteam.domain.model.Content
import com.devflowteam.domain.model.Credit

class Temp {

    fun getArticle(): Article = Article(
        createdAt = System.currentTimeMillis(),
        isFavorite = false,
        title = "Kotlin for Android Developers",
        link = "https://example.com/article1",
        description = "Intro to Kotlin in Android development.",
        categories = listOf(Category("dev", "Kotlin")),
        pubDate = "2025-05-01",
        guid = "a1",
        contents = listOf(Content("image/jpeg", "640", "https://example.com/image1.jpg", Credit("author", "Jane Doe"))),
        dcCreator = "Jane Doe",
        dcDate = "2025-05-01T10:00:00Z"
    )

    fun getArticleList(): List<Article> {
        return listOf(
            Article(
                createdAt = System.currentTimeMillis(),
                isFavorite = false,
                title = "Kotlin for Android Developers",
                link = "https://example.com/article1",
                description = "Intro to Kotlin in Android development.",
                categories = listOf(Category("dev", "Kotlin")),
                pubDate = "2025-05-01",
                guid = "a1",
                contents = listOf(Content("image/jpeg", "640", "https://example.com/image1.jpg", Credit("author", "Jane Doe"))),
                dcCreator = "Jane Doe",
                dcDate = "2025-05-01T10:00:00Z"
            ),
            Article(
                createdAt = System.currentTimeMillis() - 100_000,
                isFavorite = true,
                title = "Understanding MVVM",
                link = "https://example.com/article2",
                description = "Deep dive into MVVM architecture.",
                categories = listOf(Category("architecture", "MVVM")),
                pubDate = "2025-05-02",
                guid = "a2",
                contents = listOf(Content("image/png", "800", "https://example.com/image2.png", Credit("editor", "John Smith"))),
                dcCreator = "John Smith",
                dcDate = "2025-05-02T09:00:00Z"
            ),
            Article(
                createdAt = System.currentTimeMillis() - 200_000,
                isFavorite = false,
                title = "Room Database Tips",
                link = "https://example.com/article3",
                description = "Optimize your Room setup.",
                categories = listOf(Category("db", "Room")),
                pubDate = "2025-05-03",
                guid = "a3",
                contents = listOf(Content(null, null, "https://example.com/image3.jpg", null)),
                dcCreator = "Alice",
                dcDate = "2025-05-03T08:00:00Z"
            ),
            Article(
                createdAt = System.currentTimeMillis() - 300_000,
                isFavorite = true,
                title = "Jetpack Compose Basics",
                link = "https://example.com/article4",
                description = "Learn the basics of Jetpack Compose.",
                categories = listOf(Category("ui", "Compose")),
                pubDate = "2025-05-04",
                guid = "a4",
                contents = listOf(Content("image/jpeg", "1024", "https://example.com/image4.jpg", Credit(null, "Compose Team"))),
                dcCreator = "Compose Team",
                dcDate = "2025-05-04T12:00:00Z"
            ),
            Article(
                createdAt = System.currentTimeMillis() - 400_000,
                isFavorite = false,
                title = "Retrofit with Coroutines",
                link = "https://example.com/article5",
                description = "Making network calls with Retrofit and Coroutines.",
                categories = listOf(Category("network", "Retrofit")),
                pubDate = "2025-05-05",
                guid = "a5",
                contents = listOf(Content("image/png", "600", "https://example.com/image5.png", Credit("api", "NetTeam"))),
                dcCreator = "NetTeam",
                dcDate = "2025-05-05T14:00:00Z"
            ),
            Article(
                createdAt = System.currentTimeMillis() - 500_000,
                isFavorite = false,
                title = "Dependency Injection with Hilt",
                link = "https://example.com/article6",
                description = "Set up Hilt in your Android app.",
                categories = listOf(Category("di", "Hilt")),
                pubDate = "2025-05-06",
                guid = "a6",
                contents = listOf(Content(null, null, "https://example.com/image6.jpg", null)),
                dcCreator = "Hilt Docs",
                dcDate = "2025-05-06T11:00:00Z"
            ),
            Article(
                createdAt = System.currentTimeMillis() - 600_000,
                isFavorite = true,
                title = "Using Flow in Kotlin",
                link = "https://example.com/article7",
                description = "Reactive streams with Kotlin Flow.",
                categories = listOf(Category("coroutines", "Flow")),
                pubDate = "2025-05-07",
                guid = "a7",
                contents = listOf(Content("image/jpeg", "720", "https://example.com/image7.jpg", Credit("kotlinx", "JetBrains"))),
                dcCreator = "JetBrains",
                dcDate = "2025-05-07T16:00:00Z"
            ),
            Article(
                createdAt = System.currentTimeMillis() - 700_000,
                isFavorite = false,
                title = "Modularization in Android",
                link = "https://example.com/article8",
                description = "Splitting your project into modules.",
                categories = listOf(Category("architecture", "Modularization")),
                pubDate = "2025-05-08",
                guid = "a8",
                contents = listOf(Content("image/png", "1280", "https://example.com/image8.png", null)),
                dcCreator = "DevPro",
                dcDate = "2025-05-08T13:00:00Z"
            ),
            Article(
                createdAt = System.currentTimeMillis() - 800_000,
                isFavorite = true,
                title = "Secure Data with DataStore",
                link = "https://example.com/article9",
                description = "Storing key-value pairs securely.",
                categories = listOf(Category("storage", "DataStore")),
                pubDate = "2025-05-09",
                guid = "a9",
                contents = listOf(Content("image/jpeg", "900", "https://example.com/image9.jpg", Credit("team", "SecureTeam"))),
                dcCreator = "SecureTeam",
                dcDate = "2025-05-09T18:00:00Z"
            ),
            Article(
                createdAt = System.currentTimeMillis() - 900_000,
                isFavorite = false,
                title = "Advanced Navigation in Jetpack",
                link = "https://example.com/article10",
                description = "Handling navigation edge cases.",
                categories = listOf(Category("navigation", "Jetpack")),
                pubDate = "2025-05-10",
                guid = "a10",
                contents = listOf(Content("image/png", "720", "https://example.com/image10.png", Credit("nav", "AndroidX"))),
                dcCreator = "AndroidX",
                dcDate = "2025-05-10T15:00:00Z"
            )
        )
    }
}