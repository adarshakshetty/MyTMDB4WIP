package com.wipro.movie.features.movie.presentation

import app.cash.turbine.test
import com.wipro.movie.core.domain.watchlist.usecase.AddMovieToWatchlistUseCase
import com.wipro.movie.core.domain.watchlist.usecase.CheckMovieInWatchlistUseCase
import com.wipro.movie.core.domain.watchlist.usecase.RemoveMovieFromWatchlistUseCase
import com.wipro.movie.core.model.watchlist.MovieWatchlistState
import com.wipro.movie.core.testing.fakes.watchlist.DummyWatchlistRepositoryImpl
import com.wipro.movie.core.testing.models.movieDto
import com.wipro.movie.core.testing.models.movieEntity
import com.wipro.movie.core.testing.models.watchlistEntity1
import com.wipro.movie.core.testing.models.watchlistEntity2
import com.wipro.movie.core.testing.util.CoroutineRule
import com.wipro.movie.feature.movie.data.repository.MovieRepositoryImpl
import com.wipro.movie.feature.movie.domain.model.MovieLocalMapper
import com.wipro.movie.feature.movie.domain.model.MovieRemoteToLocalMapper
import com.wipro.movie.feature.movie.domain.usecase.GetMovieUseCase
import com.wipro.movie.feature.movie.presentation.MovieUiState
import com.wipro.movie.feature.movie.presentation.MovieViewModel
import com.wipro.movie.features.movie.data.repository.datasource.fakes.DummyMovieCacheDataSourceImpl
import com.wipro.movie.features.movie.data.repository.datasource.fakes.DummyMovieLocalDataSourceImpl
import com.wipro.movie.features.movie.data.repository.datasource.fakes.DummyMovieRemoteDataSourceImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    private lateinit var viewModel: MovieViewModel

    private lateinit var dummyWatchlistRepositoryImpl: DummyWatchlistRepositoryImpl

    private lateinit var dummyMovieCacheDataSourceImpl: DummyMovieCacheDataSourceImpl
    private lateinit var dummyMovieLocalDataSourceImpl: DummyMovieLocalDataSourceImpl
    private lateinit var dummyMovieRemoteDataSourceImpl: DummyMovieRemoteDataSourceImpl

    @Before
    fun setUp() {
        dummyWatchlistRepositoryImpl = DummyWatchlistRepositoryImpl()
        dummyMovieCacheDataSourceImpl =
            DummyMovieCacheDataSourceImpl()
        dummyMovieLocalDataSourceImpl =
            DummyMovieLocalDataSourceImpl()
        dummyMovieRemoteDataSourceImpl =
            DummyMovieRemoteDataSourceImpl()

        val movieRepository = MovieRepositoryImpl(
            remoteDataSource = dummyMovieRemoteDataSourceImpl,
            localDataSource = dummyMovieLocalDataSourceImpl,
            cacheDataSource = dummyMovieCacheDataSourceImpl,
            remoteToLocalMapper = MovieRemoteToLocalMapper(),
            localMapper = MovieLocalMapper(),
        )

        viewModel = MovieViewModel(
            GetMovieUseCase(movieRepository),
            AddMovieToWatchlistUseCase(dummyWatchlistRepositoryImpl),
            RemoveMovieFromWatchlistUseCase(dummyWatchlistRepositoryImpl),
            CheckMovieInWatchlistUseCase(dummyWatchlistRepositoryImpl),
        )
    }

    @Test
    fun `calling getMovie() with cache data goes through expected ui states`() = runTest {
        val movie = MovieLocalMapper().map(movieEntity)
        dummyMovieCacheDataSourceImpl.initWithInitialList(
            listOf(movie),
        )

        assert(viewModel.uiState.value is MovieUiState.Empty)

        launch {
            viewModel.uiState.test {
                assert(awaitItem() is MovieUiState.Empty)
                with(awaitItem()) {
                    assert(this is MovieUiState.Success)
                    assertEquals((this as MovieUiState.Success).movie, movie)
                }
            }
        }
        runCurrent()

        viewModel.getMovie(movie.id)
        runCurrent()
    }

    @Test
    fun `calling getMovie() with local data goes through expected ui states`() = runTest {
        val movie = MovieLocalMapper().map(movieEntity)
        dummyMovieLocalDataSourceImpl.initWithInitialList(
            listOf(movieEntity),
        )

        assert(viewModel.uiState.value is MovieUiState.Empty)

        launch {
            viewModel.uiState.test {
                assert(awaitItem() is MovieUiState.Empty)
                with(awaitItem()) {
                    assert(this is MovieUiState.Success)
                    assertEquals((this as MovieUiState.Success).movie, movie)
                }
            }
        }
        runCurrent()

        viewModel.getMovie(movie.id)
        runCurrent()
    }

    @Test
    fun `calling getMovie() with remote data goes through expected ui states`() = runTest {
        val movieEntity = MovieRemoteToLocalMapper().map(movieDto)
        val movie = MovieLocalMapper().map(movieEntity)

        assert(viewModel.uiState.value is MovieUiState.Empty)

        launch {
            viewModel.uiState.test {
                assert(awaitItem() is MovieUiState.Empty)
                with(awaitItem()) {
                    assert(this is MovieUiState.Success)
                    assertEquals((this as MovieUiState.Success).movie, movie)
                }
            }
        }
        runCurrent()

        viewModel.getMovie(movie.id)
        runCurrent()
    }

    @Test
    fun `calling getMovie() with remote data without success goes through expected ui states`() =
        runTest {
            val movie = MovieRemoteToLocalMapper().map(movieDto)
            dummyMovieRemoteDataSourceImpl.isSuccessful = false

            assert(viewModel.uiState.value is MovieUiState.Empty)

            launch {
                viewModel.uiState.test {
                    assert(awaitItem() is MovieUiState.Empty)
                }
            }
            launch {
                viewModel.stateError.test {
                    awaitItem() // There should be error and code should be able to access the line below
                    assert(true)
                }
            }
            runCurrent()

            viewModel.getMovie(movie.id)
            runCurrent()
        }

    @Test
    fun `calling isInWatchlist() goes through expected ui states`() = runTest {
        assert(viewModel.uiState.value is MovieUiState.Empty)
        dummyWatchlistRepositoryImpl.watchlistMoviesMap[watchlistEntity1.movieId] = watchlistEntity1
        launch {
            viewModel.uiState.test {
                // For the first call
                assert(awaitItem() is MovieUiState.Empty)
                with(awaitItem()) {
                    assert(this is MovieUiState.Success)
                    val expectedStatus = MovieWatchlistState(
                        isInWatchlist = true,
                    )
                    assertEquals((this as MovieUiState.Success).isMovieInWatchlist, expectedStatus)
                }
                // For the second call
                with(awaitItem()) {
                    assert(this is MovieUiState.Success)
                    val expectedStatus = MovieWatchlistState(
                        isInWatchlist = false,
                    )
                    assertEquals((this as MovieUiState.Success).isMovieInWatchlist, expectedStatus)
                }
            }
        }
        runCurrent()

        viewModel.isInWatchlist(watchlistEntity1.movieId)
        runCurrent()

        viewModel.isInWatchlist(watchlistEntity2.movieId)
        runCurrent()
    }

    @Test
    fun `calling addToWatchlist() adds movie to watchlist`() = runTest {
        launch {
            viewModel.uiState.test {
                // For the first call
                assert(awaitItem() is MovieUiState.Empty)
                with(awaitItem()) {
                    assert(this is MovieUiState.Success)
                    val expectedStatus = MovieWatchlistState(
                        isInWatchlist = true,
                    )
                    assertEquals((this as MovieUiState.Success).isMovieInWatchlist, expectedStatus)
                }
            }
        }
        runCurrent()

        viewModel.addToWatchlist(watchlistEntity1.movieId)
        runCurrent()

        assert(dummyWatchlistRepositoryImpl.watchlistMoviesMap.contains(watchlistEntity1.movieId))
    }

    @Test
    fun `calling removeFromWatchlist() removes movie from watchlist`() = runTest {
        dummyWatchlistRepositoryImpl.watchlistMoviesMap[watchlistEntity1.movieId] = watchlistEntity1
        launch {
            viewModel.uiState.test {
                // For the first call
                assert(awaitItem() is MovieUiState.Empty)
                with(awaitItem()) {
                    assert(this is MovieUiState.Success)
                    val expectedStatus = MovieWatchlistState(
                        isInWatchlist = false,
                    )
                    assertEquals((this as MovieUiState.Success).isMovieInWatchlist, expectedStatus)
                }
            }
        }
        runCurrent()

        viewModel.removeFromWatchlist(watchlistEntity1.movieId)
        runCurrent()

        assert(
            dummyWatchlistRepositoryImpl.watchlistMoviesMap.contains(watchlistEntity1.movieId).not(),
        )
    }
}
