package com.wipro.movie.feature.watchlist.di

import com.wipro.movie.core.database.MainDatabase
import com.wipro.movie.core.database.dao.WatchlistDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class WatchlistDatabaseModule {

    @Singleton
    @Provides
    fun provideWatchlistDao(database: MainDatabase): WatchlistDao = database.watchlistDao()
}
