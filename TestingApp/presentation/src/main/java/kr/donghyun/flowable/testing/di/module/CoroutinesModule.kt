package kr.donghyun.flowable.testing.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kr.donghyun.flowable.domain.usecase.IoDispatcher

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesModule {
    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}