package kr.donghyun.flowable.data.mapper

import kr.donghyun.flowable.data.model.ProfileEntity
import kr.donghyun.flowable.data.model.CompetitiveRating
import kr.donghyun.flowable.domain.data.CompetitiveRatingModel
import kr.donghyun.flowable.domain.data.Profile

fun ProfileEntity.toMapping() : Profile = Profile(
    userName = this.userName,
    level = this.level,
    iconImage = this.iconImage,
    isPrivate = this.isPrivate,
    ratingLevel = this.ratingLevel,

    ratingIcon = this.ratingIcon,
    competitiveList = this.competitiveList.map { competitiveRating -> competitiveRating.toMap() }
)

fun CompetitiveRating.toMap() : CompetitiveRatingModel = CompetitiveRatingModel(
    ratingLevels = ratingLevels,
    competitivePosition = competitivePosition,
    competitiveRoleIcon = competitiveRoleIcon,
    competitiveRankIcon = competitiveRankIcon
)