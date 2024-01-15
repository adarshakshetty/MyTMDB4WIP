package com.wipro.movie.core.common.vo

import com.wipro.movie.core.common.network.NetworkException

sealed class DataState<out T> {

    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: NetworkException) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
    object Idle : DataState<Nothing>()
}
