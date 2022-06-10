package kr.donghyun.flowable.data.api

import kr.donghyun.flowable.data.model.ProfileEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileAPI {
    @GET("v1/stats/pc/{region}/{battleTag}/complete")
    suspend fun getUserProfile(
        @Path("region") region : String,
        @Path("battleTag") battleTag : String
    ) : ProfileEntity
}