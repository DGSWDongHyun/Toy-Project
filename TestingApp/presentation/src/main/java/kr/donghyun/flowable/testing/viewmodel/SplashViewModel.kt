package kr.donghyun.flowable.testing.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.donghyun.flowable.testing.base.BaseViewModel
import kr.donghyun.flowable.testing.view.MainActivity

class SplashViewModel : BaseViewModel() {

    init {
        loadingDelayTime()
    }

    private fun loadingDelayTime() {
        viewModelScope.launch {
            delay(1500)
            startFinishActivity.postValue(Pair(MainActivity::class, null))
        }
    }
}