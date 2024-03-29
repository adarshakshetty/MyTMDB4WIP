package com.wipro.movie.feature.watchlist.domain.repository

import androidx.paging.PagingData
import com.wipro.movie.core.common.vo.DataState
import com.wipro.movie.core.model.watchlist.MovieWatchlistState
import com.wipro.movie.core.model.watchlist.WatchlistMovie
import kotlinx.coroutines.flow.Flow

interface WatchlistRepository {

    fun addMovie(movieId: Int): Flow<DataState<MovieWatchlistState>>
    fun removeMovie(movieId: Int): Flow<DataState<MovieWatchlistState>>
    fun getAllMovies(): Flow<PagingData<WatchlistMovie>>
    fun isMovieInWatchlist(movieId: Int): Flow<DataState<MovieWatchlistState>>
}
