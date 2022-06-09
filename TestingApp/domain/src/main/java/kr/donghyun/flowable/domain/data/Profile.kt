package kr.donghyun.flowable.domain.data

import com.google.gson.annotations.SerializedName

data class Profile(
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
    val competitiveList : List<CompetitiveRatingModel>
)

data class CompetitiveRatingModel(
    @SerializedName("level")
    val ratingLevels : Int,
    @SerializedName("role")
    val competitivePosition : String,
    @SerializedName("roleIcon")
    val competitiveRoleIcon : String,
    @SerializedName("rankIcon")
    val competitiveRankIcon : String,
)