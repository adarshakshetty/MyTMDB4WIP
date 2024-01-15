package com.wipro.movie.features.movie.data.repository.datasource.fakes

import com.wipro.movie.core.database.model.MovieEntity
import com.wipro.movie.feature.movie.data.repository.datasource.MovieLocalDataSource

class DummyMovieLocalDataSourceImpl : MovieLocalDataSource {

    private val moviesMap = hashMapOf<Int, MovieEntity>()

    fun initWithInitialList(initialList: List<MovieEntity>) {
        initialList.forEach { entity ->
            moviesMap[entity.id] = entity
        }
    }

    override suspend fun getMovie(movieId: Int): MovieEntity? = moviesMap[movieId]

    override suspend fun insertMovieToDb(entity: MovieEntity) {
        moviesMap[entity.id] = entity
    }

    override suspend fun clearAllMoviesFromDb() {
        moviesMap.clear()
    }
}
