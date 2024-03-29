package com.wipro.movie.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trending_movie_remote_keys")
data class TrendingMovieRemoteKeyEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "prevKey")
    val prevKey: Int?,
    @ColumnInfo(name = "nextKey")
    val nextKey: Int?,
)
