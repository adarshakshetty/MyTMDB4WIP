package com.wipro.movie.core.common.fakes

import androidx.lifecycle.ViewModel
import com.wipro.movie.core.common.base.LoadingOwner
import com.wipro.movie.core.common.base.combineForLoading
import com.wipro.movie.core.common.vo.DataState
import kotlinx.coroutines.flow.MutableStateFlow

class FakeLoadingOwnerViewModel : ViewModel(), LoadingOwner {
    val stateFirst = MutableStateFlow<DataState<Int>>(DataState.Idle)
    val stateSecond = MutableStateFlow<DataState<Int>>(DataState.Idle)

    override val stateLoading = combineForLoading(stateFirst, stateSecond)
}
