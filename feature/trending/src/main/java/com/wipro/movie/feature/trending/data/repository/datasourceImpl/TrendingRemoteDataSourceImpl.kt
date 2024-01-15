package com.wipro.movie.feature.trending.data.repository.datasourceImpl

import com.wipro.movie.feature.trending.data.remote.TrendingApiService
import com.wipro.movie.feature.trending.data.remote.dto.TrendingDto
import com.wipro.movie.feature.trending.data.repository.datasource.TrendingRemoteDataSource
import javax.inject.Inject

class TrendingRemoteDataSourceImpl @Inject constructor(
    private val service: TrendingApiService,
) : TrendingRemoteDataSource {
    override suspend fun getTrendingMovies(page: Int): Result<TrendingDto> =
        service.getTrendingMovies(page)
}
