package com.wipro.movie.feature.trending.presentation

import androidx.paging.testing.asSnapshot
import app.cash.turbine.test
import com.wipro.movie.core.testing.fakes.trending.DummyTrendingRemoteDataSourceImpl
import com.wipro.movie.core.testing.models.trendingMovieEntity
import com.wipro.movie.core.testing.models.trendingMovieEntity2
import com.wipro.movie.core.testing.util.CoroutineRule
import com.wipro.movie.feature.trending.data.repository.TrendingRepositoryImpl
import com.wipro.movie.feature.trending.data.repository.datasource.fakes.DummyTrendingLocalDataSourceImpl
import com.wipro.movie.feature.trending.domain.model.TrendingMovieRemoteToLocalMapper
import com.wipro.movie.feature.trending.domain.model.TrendingMoviesLocalMapper
import com.wipro.movie.feature.trending.domain.usecase.GetTrendingMoviesUseCase
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
class TrendingViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    private lateinit var viewModel: TrendingViewModel

    private lateinit var dummyTrendingLocalDataSourceImpl: DummyTrendingLocalDataSourceImpl
    private lateinit var dummyTrendingRemoteDataSourceImpl: DummyTrendingRemoteDataSourceImpl

    @Before
    fun setUp() {
        dummyTrendingLocalDataSourceImpl = DummyTrendingLocalDataSourceImpl()
        dummyTrendingRemoteDataSourceImpl = DummyTrendingRemoteDataSourceImpl()

        val trendingRepository = TrendingRepositoryImpl(
            remoteDataSource = dummyTrendingRemoteDataSourceImpl,
            localDataSource = dummyTrendingLocalDataSourceImpl,
            remoteToLocalMapper = TrendingMovieRemoteToLocalMapper(),
            localMapper = TrendingMoviesLocalMapper(),
        )
        viewModel = TrendingViewModel(
            GetTrendingMoviesUseCase(trendingRepository),
        )
    }

    @Test
    fun `trendingViewModel expected ui states`() = runTest {
        // Arrange
        val trendingMovieEntities = listOf(
            trendingMovieEntity,
            trendingMovieEntity2,
        )
        dummyTrendingRemoteDataSourceImpl.isSuccessful = true
        dummyTrendingLocalDataSourceImpl.trendingMovieEntities = trendingMovieEntities

        // Assert
        launch {
            viewModel.uiState.test {
                with(awaitItem()) {
                    assert(this is TrendingUiState.Success)
                    val pagingDataContent = flow {
                        emit((this@with as TrendingUiState.Success).pagingData)
                    }.asSnapshot()
                    assert(pagingDataContent.isEmpty())
                }
                with(awaitItem()) {
                    assert(this is TrendingUiState.Success)
                    val pagingDataContent = flow {
                        emit((this@with as TrendingUiState.Success).pagingData)
                    }.asSnapshot()
                    assertEquals(
                        pagingDataContent,
                        trendingMovieEntities.map {
                            TrendingMoviesLocalMapper().map(it)
                        },
                    )
                }
            }
        }
        runCurrent()
    }
}
