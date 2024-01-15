package com.wipro.movie.feature.watchlist.domain.usecase

import androidx.paging.PagingData
import com.wipro.movie.core.domain.watchlist.repository.WatchlistRepository
import com.wipro.movie.core.model.watchlist.WatchlistMovie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesFromWatchlistUseCase @Inject constructor(private val repository: WatchlistRepository) {

    operator fun invoke(): Flow<PagingData<WatchlistMovie>> = repository.getAllMovies()
}
