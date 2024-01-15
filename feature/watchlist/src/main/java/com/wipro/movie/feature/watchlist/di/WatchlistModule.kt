package com.wipro.movie.feature.watchlist.di

import com.wipro.movie.core.common.util.Mapper
import com.wipro.movie.core.database.model.MovieEntity
import com.wipro.movie.core.domain.watchlist.repository.WatchlistRepository
import com.wipro.movie.core.model.watchlist.WatchlistMovie
import com.wipro.movie.feature.watchlist.data.repository.WatchlistRepositoryImpl
import com.wipro.movie.feature.watchlist.data.repository.datasource.WatchlistLocalDataSource
import com.wipro.movie.feature.watchlist.data.repository.datasourceImpl.WatchlistLocalDataSourceImpl
import com.wipro.movie.feature.watchlist.domain.model.WatchlistMovieLocalMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface WatchlistModule {

    @ViewModelScoped
    @Binds
    fun bindWatchlistRepository(repository: WatchlistRepositoryImpl): WatchlistRepository

    @ViewModelScoped
    @Binds
    fun bindLocalDataSource(impl: WatchlistLocalDataSourceImpl): WatchlistLocalDataSource

    @ViewModelScoped
    @Binds
    fun bindLocalMapper(impl: WatchlistMovieLocalMapper): Mapper<MovieEntity, WatchlistMovie>
}
