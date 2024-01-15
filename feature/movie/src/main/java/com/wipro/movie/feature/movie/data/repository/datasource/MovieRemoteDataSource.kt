package com.wipro.movie.feature.movie.data.repository.datasource

import com.wipro.movie.feature.movie.data.remote.dto.MovieDto

interface MovieRemoteDataSource {

    suspend fun getMovie(movieId: Int): Result<MovieDto>
}
