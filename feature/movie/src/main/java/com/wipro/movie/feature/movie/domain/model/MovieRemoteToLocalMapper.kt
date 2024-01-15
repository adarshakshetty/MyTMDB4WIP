package com.wipro.movie.feature.movie.domain.model

import com.wipro.movie.core.common.util.Mapper
import com.wipro.movie.core.database.model.MovieEntity
import com.wipro.movie.feature.movie.data.remote.dto.MovieDto
import javax.inject.Inject

class MovieRemoteToLocalMapper @Inject constructor() : Mapper<MovieDto, MovieEntity> {

    override suspend fun map(from: MovieDto): MovieEntity = MovieEntity(
        id = from.id,
        description = from.description,
        tagline = from.tagline,
        posterPath = from.posterPath,
        releaseDate = from.releaseDate,
        title = from.title,
        voteAverage = from.voteAverage,
        genre = from.genres?.firstOrNull()?.name,
    )
}
