package com.wipro.movie.feature.watchlist.data.repository

import androidx.paging.testing.asSnapshot
import app.cash.turbine.test
import com.wipro.movie.core.common.extensions.orFalse
import com.wipro.movie.core.common.extensions.orTrue
import com.wipro.movie.core.common.vo.DataState
import com.wipro.movie.core.database.model.WatchlistEntity
import com.wipro.movie.core.testing.fakes.watchlist.DummyWatchlistLocalDataSourceImpl
import com.wipro.movie.core.testing.models.movieEntity
import com.wipro.movie.core.testing.models.movieEntity2
import com.wipro.movie.core.testing.util.CoroutineRule
import com.wipro.movie.feature.watchlist.domain.model.WatchlistMovieLocalMapper
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class WatchlistRepositoryImplTest {
    @get:Rule
    val coroutineRule = CoroutineRule()

    private lateinit var watchlistRepository: WatchlistRepositoryImpl
    private lateinit var dummyWatchlistLocalDataSourceImpl: DummyWatchlistLocalDataSourceImpl

    @Before
    fun setUp() {
        dummyWatchlistLocalDataSourceImpl = DummyWatchlistLocalDataSourceImpl()
        watchlistRepository = WatchlistRepositoryImpl(
            localDataSource = dummyWatchlistLocalDataSourceImpl,
            localMapper = WatchlistMovieLocalMapper(),
        )
    }

    @Test
    fun ` addMovie expected states and adds movie to local cache`() = runTest {
        // Arrange
        val movieId = 1

        // Act
        val addMovieFlow = watchlistRepository.addMovie(movieId)

        // Assert
        launch {
            addMovieFlow.test {
                assert(awaitItem() is DataState.Loading)
                val dataState = awaitItem()
                assert(dataState is DataState.Success)
                assert((dataState as? DataState.Success)?.data?.isInWatchlist.orFalse())
                cancelAndIgnoreRemainingEvents()
            }
            assert(dummyWatchlistLocalDataSourceImpl.isMovieInWatchlist(movieId = movieId))
        }
        runCurrent()
    }

    @Test
    fun `removes Movie expected states and from local cache`() =
        runTest {
            // Arrange
            val movieId = 1
            watchlistRepository.addMovie(movieId)

            // Act
            val removeMovieFlow = watchlistRepository.removeMovie(movieId)

            // Assert
            launch {
                removeMovieFlow.test {
                    assert(awaitItem() is DataState.Loading)
                    val dataState = awaitItem()
                    assert(dataState is DataState.Success)
                    assertFalse((dataState as? DataState.Success)?.data?.isInWatchlist.orTrue())
                    cancelAndIgnoreRemainingEvents()
                }
                assertFalse(dummyWatchlistLocalDataSourceImpl.isMovieInWatchlist(movieId = movieId))
            }
            runCurrent()
        }

    @Test
    fun `getAllMovies expected states and retrieves all movies from local cache`() =
        runTest {
            // Arrange
            val movieEntities = listOf(
                movieEntity,
                movieEntity2,
            )
            dummyWatchlistLocalDataSourceImpl.movieEntitiesForPagingSource = movieEntities

            // Act
            val getAllMovieFlow = watchlistRepository.getAllMovies()

            // Assert
            launch {
                val watchlistMovies = getAllMovieFlow.asSnapshot()
                assertEquals(
                    expected = movieEntities.map {
                        WatchlistMovieLocalMapper().map(it)
                    },
                    actual = watchlistMovies,
                )
            }
            runCurrent()
        }

    @Test
    fun `isMovieInWatchlist expected states for movie present in watchlist`() =
        runTest {
            // Arrange
            val movieId = 1
            dummyWatchlistLocalDataSourceImpl.addToWatchlist(
                WatchlistEntity(
                    movieId = movieId,
                    addedAt = System.currentTimeMillis(),
                ),
            )

            // Act
            val isMovieInWatchlistFlow = watchlistRepository.isMovieInWatchlist(movieId)

            // Assert
            launch {
                isMovieInWatchlistFlow.test {
                    assert(awaitItem() is DataState.Loading)
                    val dataState = awaitItem()
                    assert(dataState is DataState.Success)
                    assert((dataState as? DataState.Success)?.data?.isInWatchlist.orFalse())
                    cancelAndIgnoreRemainingEvents()
                }
            }
            runCurrent()
        }

    @Test
    fun `isMovieInWatchlist expected states for movie absent from watchlist`() =
        runTest {
            // Arrange
            val movieId = 1

            // Act
            val isMovieInWatchlistFlow = watchlistRepository.isMovieInWatchlist(movieId)

            // Assert
            launch {
                isMovieInWatchlistFlow.test {
                    assert(awaitItem() is DataState.Loading)
                    val dataState = awaitItem()
                    assert(dataState is DataState.Success)
                    assertFalse((dataState as? DataState.Success)?.data?.isInWatchlist.orTrue())
                    cancelAndIgnoreRemainingEvents()
                }
            }
            runCurrent()
        }
}
