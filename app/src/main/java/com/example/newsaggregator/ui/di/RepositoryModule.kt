package com.example.newsaggregator.ui.di

import com.devflowteam.data.repository.ArticleRepositoryImpl
import com.devflowteam.data.repository.RssRepositoryImpl
import com.devflowteam.domain.repository.ArticleRepository
import com.devflowteam.domain.repository.RssRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindArticleRepository(iml: ArticleRepositoryImpl): ArticleRepository

    @Binds
    @Singleton
    abstract fun bindRssRepository(impl: RssRepositoryImpl): RssRepository
}