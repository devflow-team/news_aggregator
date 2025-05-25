package com.example.newsaggregator.ui.di

import com.devflowteam.domain.repository.ArticleRepository
import com.devflowteam.domain.repository.RssRepository
import com.devflowteam.domain.usecase.GetAllRoomUseCase
import com.devflowteam.domain.usecase.GetAllRssUseCase
import com.devflowteam.domain.usecase.ReplaceOldWithNewRoomUseCase
import com.devflowteam.domain.usecase.UpdateRoomUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideReplaceOldWithNewRoomUseCase(repository: ArticleRepository) =
        ReplaceOldWithNewRoomUseCase(
            repository = repository
        )

    @Provides
    fun provideUpdateRoomUseCase(repository: ArticleRepository) =
        UpdateRoomUseCase(
            repository = repository
        )

    @Provides
    fun provideGetAllRoomUseCase(repository: ArticleRepository) =
        GetAllRoomUseCase(
            repository = repository
        )

    @Provides
    fun provideGetAllRssUseCase(repository: RssRepository) =
        GetAllRssUseCase(
            repository = repository
        )
}