package com.wipro.movie.core.testing.fakes.trending

import com.wipro.movie.core.testing.models.testTrendingDto
import com.wipro.movie.feature.trending.data.remote.dto.TrendingDto
import com.wipro.movie.feature.trending.data.repository.datasource.TrendingRemoteDataSource

class DummyTrendingRemoteDataSourceImpl : TrendingRemoteDataSource {

    var isSuccessful = true
    var trendingDto: TrendingDto? = null

    override suspend fun getTrendingMovies(page: Int): Result<TrendingDto> = if (isSuccessful) {
        Result.success(trendingDto ?: testTrendingDto)
    } else {
        Result.failure(RuntimeException("Cannot access to API"))
    }
}
