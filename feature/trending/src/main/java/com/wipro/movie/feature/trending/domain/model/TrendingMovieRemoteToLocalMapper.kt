package com.wipro.movie.feature.trending.domain.model

import com.wipro.movie.core.common.util.Mapper
import com.wipro.movie.core.database.model.TrendingMovieEntity
import com.wipro.movie.feature.trending.data.remote.dto.TrendingMovieDto
import javax.inject.Inject

class TrendingMovieRemoteToLocalMapper @Inject constructor() :
    Mapper<TrendingMovieDto, TrendingMovieEntity> {
    override suspend fun map(from: TrendingMovieDto): TrendingMovieEntity = TrendingMovieEntity(
        id = from.id,
        description = from.description,
        posterPath = from.posterPath,
        releaseDate = from.releaseDate,
        title = from.title,
        voteAverage = from.voteAverage,
    )
}
