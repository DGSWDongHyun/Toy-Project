package kr.donghyun.flowable.testing.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.donghyun.flowable.domain.data.Hero
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
    val listOfHeroes = mutableListOf<Pair<Hero, String>>()
    val profile : LiveData<Profile?>
        get() = _profile

    fun getSearchedProfile(region : String, battleTag : String) {
        isLoading.postValue(true)
        viewModelScope.launch {
            when(val result = getProfileUseCase(Pair(region, battleTag))) {
                is Result.Success -> {
                    _profile.postValue(result.data)
                    heroList(result.data)
                }
                else -> {
                    _profile.postValue(null)
                    isLoading.postValue(false)
                }
            }
        }
    }

    private fun addHero(hero: Hero?, name: String) = hero?.let { listOfHeroes.add(Pair(it, name)) }

    private fun heroList(result : Profile) {
        result.competitiveStats.careerHeroes.apply {
            addHero(anaCareer, "아나")
            addHero(asheCareer, "애쉬")
            addHero(baptisteCareer, "바티스트")
            addHero(bastionCareer, "바스티온")
            addHero(cassidyCareer, "캐서디")
            addHero(dVaCareer, "디바")
            addHero(doomfistCareer, "둠피스트")
            addHero(echoCareer, "에코")
            addHero(genjiCareer, "겐지")
            addHero(hanzoCareer, "한조")
            addHero(junkratCareer, "정크랫")
            addHero(lucioCareer, "루시우")
            addHero(meiCareer, "메이")
            addHero(mercyCareer, "메르시")
            addHero(moiraCareer, "모이라")
            addHero(orisaCareer, "오리사")
            addHero(pharahCareer, "파라")
            addHero(reaperCareer, "리퍼")
            addHero(reinhardtCareer, "라인하르트")
            addHero(roadHogCareer, "로드호그")
            addHero(sigmaCareer, "시그마")
            addHero(sombraCareer, "솜브라")
            addHero(symmetraCareer, "시메트라")
            addHero(soldier76Career, "솔져:76")
            addHero(torbjornCareer, "토르비욘")
            addHero(tracerCareer, "트레이서")
            addHero(widowmakerCareer, "위도우메이커")
            addHero(winstonCareer, "윈스턴")
            addHero(zaryaCareer, "자리야")
            addHero(zenyattaCareer, "젠야타")
        }
        listOfHeroes.sortByDescending { list -> list.first.average?.timeSpentOnFirePer10min }
        Log.d("TAG", "${listOfHeroes[0]}")
    }
}