package com.wipro.movie.feature.movie.data.remote

import com.wipro.movie.feature.movie.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiService {

    @GET("/3/movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") movieId: Int): Result<MovieDto>
}
