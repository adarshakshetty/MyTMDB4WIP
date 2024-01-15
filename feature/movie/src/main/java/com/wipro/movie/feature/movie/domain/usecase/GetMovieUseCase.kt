package com.wipro.movie.feature.movie.domain.usecase

import com.wipro.movie.core.common.vo.DataState
import com.wipro.movie.feature.movie.domain.model.Movie
import com.wipro.movie.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    operator fun invoke(movieId: Int): Flow<DataState<Movie>> = repository.getMovie(movieId)
}
