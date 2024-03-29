package com.wipro.movie.feature.trending.domain.model

import com.wipro.movie.core.common.util.BASE_URL_IMAGE_MOVIE_POSTER
import com.wipro.movie.core.common.util.FORMAT_DATE_MOVIE_RELEASE_PARSER
import com.wipro.movie.core.common.util.Mapper
import com.wipro.movie.core.database.model.TrendingMovieEntity
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

private const val FORMAT_DATE_TRENDING_MOVIE_RELEASE_FORMATTER = "dd MMM yyyy"

class TrendingMoviesLocalMapper @Inject constructor() : Mapper<TrendingMovieEntity, TrendingMovie> {
    override suspend fun map(from: TrendingMovieEntity): TrendingMovie {
        val parser = SimpleDateFormat(FORMAT_DATE_MOVIE_RELEASE_PARSER, Locale.ENGLISH)
        val formatter =
            SimpleDateFormat(FORMAT_DATE_TRENDING_MOVIE_RELEASE_FORMATTER, Locale.ENGLISH)
        return TrendingMovie(
            id = from.id,
            description = from.description.orEmpty(),
            posterUrl = BASE_URL_IMAGE_MOVIE_POSTER + from.posterPath,
            releaseDate = runCatching {
                parser.parse(from.releaseDate.orEmpty())
            }.getOrNull()?.let { releaseDate ->
                formatter.format(releaseDate)
            }.orEmpty(),
            title = from.title.orEmpty(),
            rating = from.voteAverage?.let { voteAverage ->
                "TMDB ${String.format(Locale.ENGLISH, "%.1f", voteAverage)}"
            }.orEmpty(),
        )
    }
}
