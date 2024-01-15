package com.wipro.movie.feature.watchlist.presentation

import androidx.paging.testing.asSnapshot
import app.cash.turbine.test
import com.wipro.movie.core.testing.fakes.watchlist.DummyWatchlistLocalDataSourceImpl
import com.wipro.movie.core.testing.models.movieEntity
import com.wipro.movie.core.testing.models.movieEntity2
import com.wipro.movie.core.testing.util.CoroutineRule
import com.wipro.movie.feature.watchlist.data.repository.WatchlistRepositoryImpl
import com.wipro.movie.feature.watchlist.domain.model.WatchlistMovieLocalMapper
import com.wipro.movie.feature.watchlist.domain.usecase.GetMoviesFromWatchlistUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class WatchlistViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    private lateinit var viewModel: WatchlistViewModel

    private lateinit var dummyWatchlistLocalDataSourceImpl: DummyWatchlistLocalDataSourceImpl

    @Before
    fun setUp() {
        dummyWatchlistLocalDataSourceImpl = DummyWatchlistLocalDataSourceImpl()
        val favoritesRepository = WatchlistRepositoryImpl(
            localDataSource = dummyWatchlistLocalDataSourceImpl,
            localMapper = WatchlistMovieLocalMapper(),
        )

        viewModel = WatchlistViewModel(
            GetMoviesFromWatchlistUseCase(favoritesRepository),
        )
    }

    @Test
    fun `calling getWatchlistMovies() goes through expected ui states`() = runTest {
        // Arrange
        val movieEntities = listOf(movieEntity, movieEntity2)
        dummyWatchlistLocalDataSourceImpl.movieEntitiesForPagingSource = movieEntities

        // Act
        viewModel.getMoviesFromWatchlist()

        // Assert
        launch {
            viewModel.uiState.test {
                with(awaitItem()) {
                    assert(this is WatchlistUiState.Success)
                    val pagingDataContent = flow {
                        emit((this@with as WatchlistUiState.Success).pagingData)
                    }.asSnapshot()
                    assert(pagingDataContent.isEmpty())
                }
                with(awaitItem()) {
                    assert(this is WatchlistUiState.Success)
                    val pagingDataContent = flow {
                        emit((this@with as WatchlistUiState.Success).pagingData)
                    }.asSnapshot()
                    assertEquals(
                        pagingDataContent,
                        movieEntities.map {
                            WatchlistMovieLocalMapper().map(it)
                        },
                    )
                }
            }
        }
        runCurrent()
    }
}
