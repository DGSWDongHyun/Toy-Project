package kr.donghyun.flowable.testing.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.donghyun.flowable.domain.data.Profile
import kr.donghyun.flowable.domain.usecase.GetProfileUseCase
import kr.donghyun.flowable.domain.util.Result
import kr.donghyun.flowable.testing.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase
) : BaseViewModel() {

    val isLoading = MutableLiveData(false)
    var listPhase = 0

    private val _profile = MutableLiveData<Profile?>()
    val profile : LiveData<Profile?>
        get() = _profile

    fun getSearchedProfile(region : String, battleTag : String) {
        isLoading.postValue(true)
        viewModelScope.launch {
            when(val result = getProfileUseCase(Pair(region, battleTag))) {
                is Result.Success -> {
                    Log.d("TAG", "${result.data}")
                    _profile.postValue(result.data)
                }
                else -> {
                    Log.d("TAG", "$result")
                    _profile.postValue(null)
                    isLoading.postValue(false)
                }
            }
        }
    }
}