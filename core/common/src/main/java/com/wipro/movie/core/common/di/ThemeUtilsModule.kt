package com.wipro.movie.core.common.di

import com.wipro.movie.core.common.util.ThemeUtils
import com.wipro.movie.core.common.util.ThemeUtilsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ThemeUtilsModule {

    @Singleton
    @Binds
    fun bindThemeUtils(impl: ThemeUtilsImpl): ThemeUtils
}
