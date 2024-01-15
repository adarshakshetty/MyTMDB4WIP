package com.wipro.movie.feature.trending.di

import com.wipro.movie.core.common.util.Mapper
import com.wipro.movie.core.database.model.TrendingMovieEntity
import com.wipro.movie.feature.trending.data.remote.dto.TrendingMovieDto
import com.wipro.movie.feature.trending.data.repository.TrendingRepositoryImpl
import com.wipro.movie.feature.trending.data.repository.datasource.TrendingLocalDataSource
import com.wipro.movie.feature.trending.data.repository.datasource.TrendingRemoteDataSource
import com.wipro.movie.feature.trending.data.repository.datasourceImpl.TrendingLocalDataSourceImpl
import com.wipro.movie.feature.trending.data.repository.datasourceImpl.TrendingRemoteDataSourceImpl
import com.wipro.movie.feature.trending.domain.model.TrendingMovie
import com.wipro.movie.feature.trending.domain.model.TrendingMovieRemoteToLocalMapper
import com.wipro.movie.feature.trending.domain.model.TrendingMoviesLocalMapper
import com.wipro.movie.feature.trending.domain.repository.TrendingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface TrendingModule {

    @ViewModelScoped
    @Binds
    fun bindTrendingRepository(repository: TrendingRepositoryImpl): TrendingRepository

    @ViewModelScoped
    @Binds
    fun bindRemoteDataSource(impl: TrendingRemoteDataSourceImpl): TrendingRemoteDataSource

    @ViewModelScoped
    @Binds
    fun bindLocalDataSource(impl: TrendingLocalDataSourceImpl): TrendingLocalDataSource

    @ViewModelScoped
    @Binds
    fun bindLocalMapper(impl: TrendingMoviesLocalMapper): Mapper<TrendingMovieEntity, TrendingMovie>

    @ViewModelScoped
    @Binds
    fun bindRemoteToLocalMapper(
        impl: TrendingMovieRemoteToLocalMapper,
    ): Mapper<TrendingMovieDto, TrendingMovieEntity>
}
