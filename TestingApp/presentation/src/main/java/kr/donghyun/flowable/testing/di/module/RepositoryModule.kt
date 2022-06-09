package kr.donghyun.flowable.testing.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.donghyun.flowable.data.repository.profile.ProfileRepositoryImpl
import kr.donghyun.flowable.data.repository.profile.datasource.RemoteProfileDataSource
import kr.donghyun.flowable.domain.repository.ProfileRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideProfileRepository(
        remoteProfileDataSource: RemoteProfileDataSource
    ) : ProfileRepository {
        return ProfileRepositoryImpl(remoteProfileDataSource)
    }

}