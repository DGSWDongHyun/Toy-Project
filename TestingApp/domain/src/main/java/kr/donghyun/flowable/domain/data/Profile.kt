package kr.donghyun.flowable.domain.data

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("competitiveStats")
    val competitiveStats : CompetitiveStatsEntity,
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

data class CompetitiveStatsEntity(
    @SerializedName("careerStats")
    val careerHeroes : CareerHeroesEntity,
)

data class CareerHeroesEntity(
    @SerializedName("dVa")
    val dVaCareer : Hero?,
    @SerializedName("doomfist")
    val doomfistCareer : Hero?,
    @SerializedName("orisa")
    val orisaCareer : Hero?,
    @SerializedName("reinhardt")
    val reinhardtCareer : Hero?,
    @SerializedName("roadhog")
    val roadHogCareer : Hero?,
    @SerializedName("sigma")
    val sigmaCareer : Hero?,
    @SerializedName("winston")
    val winstonCareer : Hero?,
    @SerializedName("wreckingBall")
    val wreckingBallCareer : Hero?,
    @SerializedName("zarya")
    val zaryaCareer : Hero?,
    @SerializedName("ashe")
    val asheCareer : Hero?,
    @SerializedName("bastion")
    val bastionCareer : Hero?,
    @SerializedName("cassidy")
    val cassidyCareer : Hero?,
    @SerializedName("echo")
    val echoCareer : Hero?,
    @SerializedName("genji")
    val genjiCareer : Hero?,
    @SerializedName("hanzo")
    val hanzoCareer : Hero?,
    @SerializedName("junkrat")
    val junkratCareer : Hero?,
    @SerializedName("mei")
    val meiCareer : Hero?,
    @SerializedName("pharah")
    val pharahCareer : Hero?,
    @SerializedName("reaper")
    val reaperCareer : Hero?,
    @SerializedName("soldier76")
    val soldier76Career : Hero?,
    @SerializedName("sombra")
    val sombraCareer : Hero?,
    @SerializedName("symmetra")
    val symmetraCareer : Hero?,
    @SerializedName("torbjorn")
    val torbjornCareer : Hero?,
    @SerializedName("tracer")
    val tracerCareer : Hero?,
    @SerializedName("widowmaker")
    val widowmakerCareer : Hero?,
    @SerializedName("ana")
    val anaCareer : Hero?,
    @SerializedName("baptiste")
    val baptisteCareer : Hero?,
    @SerializedName("brigitte")
    val brigitteCareer : Hero?,
    @SerializedName("lucio")
    val lucioCareer : Hero?,
    @SerializedName("mercy")
    val mercyCareer : Hero?,
    @SerializedName("moira")
    val moiraCareer : Hero?,
    @SerializedName("zenyatta")
    val zenyattaCareer : Hero?,
)

data class Hero(
    val average : AverageDataEntity?
)

data class AverageDataEntity(
    @SerializedName("allDamageDoneAvgPer10Min")
    val allDmgPer10min : String?,
    @SerializedName("barrierDamageDoneAvgPer10Min")
    val barrierPer10min : String?,
    @SerializedName("deathsAvgPer10Min")
    val deathPer10min : String?,
    @SerializedName("heroDamageDoneAvgPer10Min")
    val heroDmgPer10min : String?,
    @SerializedName("timeSpentOnFireAvgPer10Min")
    val timeSpentOnFirePer10min : String?,
    @SerializedName("healingDoneAvgPer10Min")
    val healingPer10min : String?,
    @SerializedName("soloKillsAvgPer10Min")
    val soloKillsPer10min : String?,
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