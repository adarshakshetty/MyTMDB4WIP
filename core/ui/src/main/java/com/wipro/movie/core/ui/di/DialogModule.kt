package com.wipro.movie.core.ui.di

import android.app.Dialog
import com.wipro.movie.core.ui.dialogs.AlertDialog
import com.wipro.movie.core.ui.dialogs.LoadingDialog
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
interface DialogModule {
    @ActivityScoped
    @Binds
    fun bindLoadingDialog(impl: LoadingDialog): Dialog

    @ActivityScoped
    @Binds
    fun bindAlertDialog(impl: AlertDialog): Dialog
}
