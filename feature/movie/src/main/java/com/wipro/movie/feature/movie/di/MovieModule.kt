package com.wipro.movie.feature.movie.di

import com.wipro.movie.core.common.util.Mapper
import com.wipro.movie.core.database.model.MovieEntity
import com.wipro.movie.feature.movie.data.remote.dto.MovieDto
import com.wipro.movie.feature.movie.data.repository.MovieRepositoryImpl
import com.wipro.movie.feature.movie.data.repository.datasource.MovieCacheDataSource
import com.wipro.movie.feature.movie.data.repository.datasource.MovieLocalDataSource
import com.wipro.movie.feature.movie.data.repository.datasource.MovieRemoteDataSource
import com.wipro.movie.feature.movie.data.repository.datasourceImpl.MovieCacheDataSourceImpl
import com.wipro.movie.feature.movie.data.repository.datasourceImpl.MovieLocalDataSourceImpl
import com.wipro.movie.feature.movie.data.repository.datasourceImpl.MovieRemoteDataSourceImpl
import com.wipro.movie.feature.movie.domain.model.Movie
import com.wipro.movie.feature.movie.domain.model.MovieLocalMapper
import com.wipro.movie.feature.movie.domain.model.MovieRemoteToLocalMapper
import com.wipro.movie.feature.movie.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface MovieModule {

    @ViewModelScoped
    @Binds
    fun bindMovieRepository(repository: MovieRepositoryImpl): MovieRepository

    @ViewModelScoped
    @Binds
    fun bindRemoteDataSource(impl: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @ViewModelScoped
    @Binds
    fun bindLocalDataSource(impl: MovieLocalDataSourceImpl): MovieLocalDataSource

    @ViewModelScoped
    @Binds
    fun bindLocalMapper(impl: MovieLocalMapper): Mapper<MovieEntity, Movie>

    @ViewModelScoped
    @Binds
    fun bindRemoteToLocalMapper(impl: MovieRemoteToLocalMapper): Mapper<MovieDto, MovieEntity>
}

@Module
@InstallIn(SingletonComponent::class)
interface MovieSingletonModule {
    @Singleton
    @Binds
    fun bindCacheDataSource(impl: MovieCacheDataSourceImpl): MovieCacheDataSource
}
