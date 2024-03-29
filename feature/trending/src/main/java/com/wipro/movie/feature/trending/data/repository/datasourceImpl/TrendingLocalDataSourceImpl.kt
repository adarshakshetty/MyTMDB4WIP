package com.wipro.movie.feature.trending.data.repository.datasourceImpl

import androidx.paging.LoadType
import androidx.paging.PagingSource
import com.wipro.movie.core.database.model.TrendingMovieEntity
import com.wipro.movie.core.database.model.TrendingMovieRemoteKeyEntity
import com.wipro.movie.feature.trending.data.repository.datasource.TrendingLocalDataSource
import javax.inject.Inject

class TrendingLocalDataSourceImpl @Inject constructor(
    private val trendingMoviesDao: com.wipro.movie.core.database.dao.TrendingMoviesDao,
    private val trendingMovieRemoteKeysDao: com.wipro.movie.core.database.dao.TrendingMovieRemoteKeysDao,
) : TrendingLocalDataSource {

    override fun getPagingSourceFromDb(): PagingSource<Int, TrendingMovieEntity> =
        trendingMoviesDao.getPagingSource()

    override suspend fun insertAllMoviesToDb(list: List<TrendingMovieEntity>) {
        trendingMoviesDao.upsertAll(list)
    }

    override suspend fun clearAllMoviesFromDb() {
        trendingMoviesDao.clearAll()
    }

    override suspend fun refreshDataForPaging(
        loadType: LoadType,
        page: Int,
        movies: List<TrendingMovieEntity>,
    ) {
        trendingMoviesDao.deleteAndInsertTransactionForPaging(
            loadType,
            page,
            movies,
            trendingMovieRemoteKeysDao,
        )
    }

    override suspend fun insertAllRemoteKeysToDb(list: List<TrendingMovieRemoteKeyEntity>) {
        trendingMovieRemoteKeysDao.upsertAll(list)
    }

    override suspend fun getRemoteKeyFromDb(movieId: Int): TrendingMovieRemoteKeyEntity? =
        trendingMovieRemoteKeysDao.getRemoteKey(movieId)

    override suspend fun clearAllRemoteKeysFromDb() {
        trendingMovieRemoteKeysDao.clearAll()
    }
}
