package com.wipro.movie.core.testing.fakes.watchlist

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.wipro.movie.core.common.vo.DataState
import com.wipro.movie.core.database.model.MovieEntity
import com.wipro.movie.core.database.model.WatchlistEntity
import com.wipro.movie.core.domain.watchlist.repository.WatchlistRepository
import com.wipro.movie.core.model.watchlist.MovieWatchlistState
import com.wipro.movie.core.model.watchlist.WatchlistMovie
import com.wipro.movie.feature.watchlist.data.repository.INITIAL_LOAD_SIZE
import com.wipro.movie.feature.watchlist.data.repository.PAGE_SIZE
import com.wipro.movie.feature.watchlist.data.repository.PREFETCH_DISTANCE
import com.wipro.movie.feature.watchlist.domain.model.WatchlistMovieLocalMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class DummyWatchlistRepositoryImpl : WatchlistRepository {

    val watchlistMoviesMap = hashMapOf<Int, WatchlistEntity>()
    var movieEntities = emptyList<MovieEntity>()

    override fun addMovie(movieId: Int): Flow<DataState<MovieWatchlistState>> = flow {
        emit(DataState.Loading)
        watchlistMoviesMap[movieId] = WatchlistEntity(
            movieId = movieId,
            addedAt = System.currentTimeMillis(),
        )
        emit(DataState.Success(MovieWatchlistState(isInWatchlist = true)))
    }

    override fun removeMovie(movieId: Int): Flow<DataState<MovieWatchlistState>> = flow {
        emit(DataState.Loading)
        watchlistMoviesMap.remove(movieId)
        emit(DataState.Success(MovieWatchlistState(isInWatchlist = false)))
    }

    override fun getAllMovies(): Flow<PagingData<WatchlistMovie>> = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PREFETCH_DISTANCE,
            initialLoadSize = INITIAL_LOAD_SIZE,
        ),
        pagingSourceFactory = { FakePagingSource(movieEntities) },
    ).flow.map { pagingData ->
        pagingData.map {
            WatchlistMovieLocalMapper().map(it)
        }
    }

    override fun isMovieInWatchlist(movieId: Int): Flow<DataState<MovieWatchlistState>> = flow {
        emit(DataState.Loading)
        val isExist = watchlistMoviesMap.contains(movieId)
        emit(DataState.Success(MovieWatchlistState(isInWatchlist = isExist)))
    }
}
