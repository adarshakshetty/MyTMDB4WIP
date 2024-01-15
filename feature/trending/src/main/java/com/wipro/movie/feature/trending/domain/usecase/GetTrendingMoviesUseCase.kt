package com.wipro.movie.feature.trending.domain.usecase

import androidx.paging.PagingData
import com.wipro.movie.feature.trending.domain.model.TrendingMovie
import com.wipro.movie.feature.trending.domain.repository.TrendingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(private val repository: TrendingRepository) {
    operator fun invoke(): Flow<PagingData<TrendingMovie>> = repository.getTrendingMovies()
}
