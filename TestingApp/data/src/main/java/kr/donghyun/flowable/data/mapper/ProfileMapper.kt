package kr.donghyun.flowable.data.mapper

import kr.donghyun.flowable.data.model.*
import kr.donghyun.flowable.domain.data.*
import kr.donghyun.flowable.domain.data.Hero

fun ProfileEntity.toMapping() : Profile = Profile(
    competitiveStats = this.competitiveStats.toMapping(),
    userName = this.userName,
    level = this.level,
    iconImage = this.iconImage,
    isPrivate = this.isPrivate,
    ratingLevel = this.ratingLevel,
    ratingIcon = this.ratingIcon,
    competitiveList = this.competitiveList.map { competitiveRating -> competitiveRating.toMap() }
)

fun CompetitiveStats.toMapping() : CompetitiveStatsEntity = CompetitiveStatsEntity(
    careerHeroes = careerHeroes.toMapping()
)

fun CareerHeroes.toMapping() : CareerHeroesEntity = CareerHeroesEntity(
    anaCareer = anaCareer?.toMapping(),
    asheCareer = asheCareer?.toMapping(),
    baptisteCareer = baptisteCareer?.toMapping(),
    bastionCareer = bastionCareer?.toMapping(),
    brigitteCareer = brigitteCareer?.toMapping(),
    cassidyCareer = cassidyCareer?.toMapping(),
    doomfistCareer = doomfistCareer?.toMapping(),
    dVaCareer = dVaCareer?.toMapping(),
    echoCareer = echoCareer?.toMapping(),
    genjiCareer = genjiCareer?.toMapping(),
    hanzoCareer = hanzoCareer?.toMapping(),
    junkratCareer = junkratCareer?.toMapping(),
    lucioCareer = lucioCareer?.toMapping(),
    meiCareer = meiCareer?.toMapping(),
    mercyCareer = mercyCareer?.toMapping(),
    moiraCareer = moiraCareer?.toMapping(),
    orisaCareer = orisaCareer?.toMapping(),
    pharahCareer = pharahCareer?.toMapping(),
    reaperCareer = reaperCareer?.toMapping(),
    reinhardtCareer = reinhardtCareer?.toMapping(),
    roadHogCareer = roadHogCareer?.toMapping(),
    sigmaCareer = sigmaCareer?.toMapping(),
    soldier76Career = soldier76Career?.toMapping(),
    sombraCareer = sombraCareer?.toMapping(),
    symmetraCareer = symmetraCareer?.toMapping(),
    torbjornCareer = torbjornCareer?.toMapping(),
    tracerCareer = tracerCareer?.toMapping(),
    widowmakerCareer = widowmakerCareer?.toMapping(),
    winstonCareer = winstonCareer?.toMapping(),
    wreckingBallCareer = wreckingBallCareer?.toMapping(),
    zaryaCareer = zaryaCareer?.toMapping(),
    zenyattaCareer = zenyattaCareer?.toMapping()
)

fun kr.donghyun.flowable.data.model.Hero.toMapping() : Hero = Hero(
    average = this.average?.toMapping()
)

fun AverageData.toMapping() : AverageDataEntity = AverageDataEntity(
    allDmgPer10min = this.allDmgPer10min,
    barrierPer10min = this.barrierPer10min,
    deathPer10min = this.deathPer10min,
    heroDmgPer10min = this.heroDmgPer10min,
    timeSpentOnFirePer10min = this.timeSpentOnFirePer10min,
    healingPer10min = this.healingPer10min,
    soloKillsPer10min = this.soloKillsPer10min
)

fun CompetitiveRating.toMap() : CompetitiveRatingModel = CompetitiveRatingModel(
    ratingLevels = ratingLevels,
    competitivePosition = competitivePosition,
    competitiveRoleIcon = competitiveRoleIcon,
    competitiveRankIcon = competitiveRankIcon
)