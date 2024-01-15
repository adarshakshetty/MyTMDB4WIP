package com.wipro.movie.feature.trending.di

import com.wipro.movie.core.database.MainDatabase
import com.wipro.movie.core.database.dao.TrendingMovieRemoteKeysDao
import com.wipro.movie.core.database.dao.TrendingMoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [TrendingDatabaseModule::class],
)
object TestTrendingDatabaseModule {

    @Singleton
    @Provides
    fun provideTrendingMoviesDao(database: MainDatabase): TrendingMoviesDao =
        database.trendingMoviesDao()

    @Singleton
    @Provides
    fun provideTrendingMovieRemoteKeysDao(database: MainDatabase): TrendingMovieRemoteKeysDao =
        database.trendingMovieRemoteKeysDao()
}
