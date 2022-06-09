package kr.donghyun.flowable.data.model

import com.google.gson.annotations.SerializedName

data class ProfileEntity(
    @SerializedName("name")
    val userName : String,
    @SerializedName("icon")
    val iconImage : String,
    @SerializedName("level")
    val level : String,
    @SerializedName("private")
    val isPrivate : Boolean,
    @SerializedName("rating")
    val ratingLevel : String,
    @SerializedName("ratingIcon")
    val ratingIcon : String,
    @SerializedName("ratings")
    val competitiveList : List<CompetitiveRating>
)

data class CompetitiveRating(
    @SerializedName("level")
    val ratingLevels : Int,
    @SerializedName("role")
    val competitivePosition : String,
    @SerializedName("roleIcon")
    val competitiveRoleIcon : String,
    @SerializedName("rankIcon")
    val competitiveRankIcon : String,
)