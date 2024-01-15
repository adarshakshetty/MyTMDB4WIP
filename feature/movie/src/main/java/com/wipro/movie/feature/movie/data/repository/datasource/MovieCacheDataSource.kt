package com.wipro.movie.feature.movie.data.repository.datasource

import com.wipro.movie.feature.movie.domain.model.Movie

interface MovieCacheDataSource {

    fun getMovieFromCache(movieId: Int): Movie?
    fun saveMovieToCache(movie: Movie)
}
