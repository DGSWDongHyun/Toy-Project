package kr.donghyun.flowable.data.repository.profile

import kr.donghyun.flowable.data.mapper.toMapping
import kr.donghyun.flowable.data.repository.profile.datasource.RemoteProfileDataSource
import kr.donghyun.flowable.domain.data.Profile
import kr.donghyun.flowable.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val dataSource: RemoteProfileDataSource
) : ProfileRepository{
    override suspend fun getProfile(region : String, battleTag : String): Profile = dataSource.getProfile(region, battleTag).toMapping()
}