package kr.donghyun.flowable.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kr.donghyun.flowable.domain.data.Profile
import kr.donghyun.flowable.domain.repository.ProfileRepository
import kr.donghyun.flowable.domain.util.CoroutineUseCase
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val repository: ProfileRepository,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher
) : CoroutineUseCase<Pair<String, String>, Profile>(coroutineDispatcher) {

    override suspend fun execute(parameter: Pair<String, String>): Profile = repository.getProfile(region = parameter.first, battleTag = parameter.second)
}

annotation class IoDispatcher
