package com.wipro.movie.feature.movie.data.repository.datasourceImpl

import com.wipro.movie.feature.movie.data.remote.MovieApiService
import com.wipro.movie.feature.movie.data.remote.dto.MovieDto
import com.wipro.movie.feature.movie.data.repository.datasource.MovieRemoteDataSource
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val service: MovieApiService,
) : MovieRemoteDataSource {

    override suspend fun getMovie(movieId: Int): Result<MovieDto> = service.getMovie(movieId)
}
