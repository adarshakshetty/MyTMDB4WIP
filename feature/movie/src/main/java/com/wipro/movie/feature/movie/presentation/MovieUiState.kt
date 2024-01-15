package com.wipro.movie.feature.movie.presentation

import com.wipro.movie.core.model.watchlist.MovieWatchlistState
import com.wipro.movie.feature.movie.domain.model.Movie

sealed interface MovieUiState {

    data class Success(
        val movie: Movie?,
        val isMovieInWatchlist: MovieWatchlistState?,
    ) : MovieUiState

    object Empty : MovieUiState
}
