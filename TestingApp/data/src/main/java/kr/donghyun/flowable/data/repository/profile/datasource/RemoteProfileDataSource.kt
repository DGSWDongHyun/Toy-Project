package kr.donghyun.flowable.data.repository.profile.datasource

import kr.donghyun.flowable.data.api.ProfileAPI
import kr.donghyun.flowable.data.model.ProfileEntity
import retrofit2.Response
import javax.inject.Inject

class RemoteProfileDataSource @Inject constructor(
    private val profileAPI : ProfileAPI
) {
    suspend fun getProfile(region : String, battleTag : String) : ProfileEntity = profileAPI.getUserProfile(region = region, battleTag = battleTag)
}