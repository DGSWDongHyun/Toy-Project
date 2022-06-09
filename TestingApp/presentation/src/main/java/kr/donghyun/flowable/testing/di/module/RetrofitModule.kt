package kr.donghyun.flowable.testing.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.donghyun.flowable.data.api.BaseClient
import kr.donghyun.flowable.data.api.ProfileAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideProfileAPI() : ProfileAPI = Retrofit.Builder()
        .baseUrl(BaseClient.BASE_OW_CLIENT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProfileAPI::class.java)
}