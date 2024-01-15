package com.wipro.movie.core.domain.watchlist.usecase

import com.wipro.movie.core.common.vo.DataState
import com.wipro.movie.core.domain.watchlist.repository.WatchlistRepository
import com.wipro.movie.core.model.watchlist.MovieWatchlistState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoveMovieFromWatchlistUseCase @Inject constructor(private val repository: WatchlistRepository) {

    operator fun invoke(movieId: Int): Flow<DataState<MovieWatchlistState>> =
        repository.removeMovie(movieId)
}
