package com.wipro.movie.feature.movie.domain.repository

import com.wipro.movie.core.common.vo.DataState
import com.wipro.movie.feature.movie.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovie(movieId: Int): Flow<DataState<Movie>>
}
