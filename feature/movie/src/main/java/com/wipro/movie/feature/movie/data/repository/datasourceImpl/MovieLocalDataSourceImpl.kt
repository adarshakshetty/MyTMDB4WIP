package com.wipro.movie.feature.movie.data.repository.datasourceImpl

import com.wipro.movie.core.database.model.MovieEntity
import com.wipro.movie.feature.movie.data.repository.datasource.MovieLocalDataSource
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val moviesDao: com.wipro.movie.core.database.dao.MoviesDao,
) : MovieLocalDataSource {

    override suspend fun getMovie(movieId: Int): MovieEntity? = moviesDao.getMovie(movieId)

    override suspend fun insertMovieToDb(entity: MovieEntity) {
        moviesDao.upsert(entity)
    }

    override suspend fun clearAllMoviesFromDb() {
        moviesDao.clearAll()
    }
}
