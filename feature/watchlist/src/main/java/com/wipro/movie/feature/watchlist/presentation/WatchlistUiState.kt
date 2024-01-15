package com.wipro.movie.feature.watchlist.presentation

import androidx.paging.PagingData
import com.wipro.movie.core.model.watchlist.WatchlistMovie

sealed class WatchlistUiState {

    data class Success(
        val pagingData: PagingData<WatchlistMovie>,
    ) : WatchlistUiState()
}
