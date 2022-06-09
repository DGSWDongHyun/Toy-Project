package kr.donghyun.flowable.domain.repository

import kr.donghyun.flowable.domain.data.Profile

interface ProfileRepository {
    suspend fun getProfile(region: String, battleTag : String) : Profile
}