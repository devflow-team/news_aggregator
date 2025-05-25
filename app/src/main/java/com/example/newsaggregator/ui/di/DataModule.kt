package com.example.newsaggregator.ui.di

import android.app.Application
import androidx.room.Room
import com.devflowteam.data.local.room.ArticleDao
import com.devflowteam.data.local.room.ArticleDatabase
import com.devflowteam.data.repository.ArticleRepositoryImpl
import com.devflowteam.domain.repository.ArticleRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideArticleDao(appContext: Application): ArticleDao {
        val db = Room.databaseBuilder(
            appContext,
            ArticleDatabase::class.java,
            "article.db"
        ).build()

        return db.articleDao()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.theguardian.com")
            .addConverterFactory(
                XML.asConverterFactory(
                    MediaType.get("application/xml; charset=UTF8")
                )
            ).build()
    }
}