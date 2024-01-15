package com.wipro.movie.features.movie.data.repository.datasource.fakes

import com.wipro.movie.core.common.network.NetworkException
import com.wipro.movie.core.testing.models.movieDto
import com.wipro.movie.feature.movie.data.remote.dto.MovieDto
import com.wipro.movie.feature.movie.data.repository.datasource.MovieRemoteDataSource

class DummyMovieRemoteDataSourceImpl : MovieRemoteDataSource {

    var isSuccessful = true

    override suspend fun getMovie(movieId: Int): Result<MovieDto> {
        return if (isSuccessful) {
            Result.success(movieDto)
        } else {
            Result.failure(NetworkException(code = 1))
        }
    }
}
