package com.wipro.movie.core.common.util

import com.wipro.movie.core.common.network.NetworkException

interface ErrorHandler {

    var onDefaultPrimaryAction: () -> Unit
    var defaultTextPrimaryAction: String
    var handleBeforeGeneralException: (networkException: NetworkException) -> Boolean
    var handleAfterGeneralException: (networkException: NetworkException) -> Boolean

    fun handleException(networkException: NetworkException): Boolean
    fun handleGeneralException(networkException: NetworkException): Boolean
}
