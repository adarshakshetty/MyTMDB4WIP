package com.wipro.movie.core.ui.di

import com.wipro.movie.core.common.util.ErrorHandler
import com.wipro.movie.core.ui.util.ErrorHandlerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
interface ErrorHandlerModule {

    @FragmentScoped
    @Binds
    fun bindErrorHandler(impl: ErrorHandlerImpl): ErrorHandler
}
