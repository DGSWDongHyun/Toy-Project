package kr.donghyun.flowable.testing.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.donghyun.flowable.domain.data.Profile
import kr.donghyun.flowable.domain.usecase.GetProfileUseCase
import kr.donghyun.flowable.domain.util.Result
import kr.donghyun.flowable.testing.base.BaseViewModel
import kr.donghyun.flowable.testing.view.adapter.CompetitiveRoleAdapter
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase
) : BaseViewModel(){

    val competitiveRoleAdapter = CompetitiveRoleAdapter()
    val searchBattleTag = MutableLiveData("")
    val searchRegion = MutableLiveData("us")
    val isLoading = MutableLiveData(false)

    private val _profile = MutableLiveData<Profile?>()
    val profile : LiveData<Profile?>
        get() = _profile

    fun getSearchedProfile() {
        isLoading.postValue(true)
        viewModelScope.launch {
            when(val result = getProfileUseCase(Pair(searchRegion.value!!, searchBattleTag.value!!))) {
                is Result.Success -> {
                    _profile.postValue(result.data)
                    competitiveRoleAdapter.updateRoleData(result.data.competitiveList)
                    isLoading.postValue(false)
                }
                else -> {
                    _profile.postValue(null)
                    isLoading.postValue(false)
                }
            }
        }
    }

    fun bindRegion() : String {
        return when(searchRegion.value) {
            "us" -> "북미 서버"
            "eu" -> "유럽 서버"
            "asia" -> "아시아 서버"
            else -> ""
        }
    }
}