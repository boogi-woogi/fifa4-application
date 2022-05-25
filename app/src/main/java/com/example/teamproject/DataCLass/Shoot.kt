package com.example.teamproject.DataCLass

import com.google.gson.annotations.SerializedName

data class Shoot(
    @SerializedName("effectiveShootTotal")val effectiveShootTotal: Int,
    @SerializedName("goalFreekick")val goalFreekick: Int,
    @SerializedName("goalHeading") val goalHeading: Int,
    @SerializedName("goalInPenalty")val goalInPenalty: Int,
    @SerializedName("goalOutPenalty")val goalOutPenalty: Int,
    @SerializedName("goalPenaltyKick")val goalPenaltyKick: Int,
    @SerializedName("goalTotal")val goalTotal: Int,
    @SerializedName("goalTotalDisplay")val goalTotalDisplay: Int,
    @SerializedName("ownGoal")val ownGoal: Int,
    @SerializedName("shootFreekick")val shootFreekick: Int,
    @SerializedName("shootHeading")val shootHeading: Int,
    @SerializedName("shootInPenalty") val shootInPenalty: Int,
    @SerializedName("shootOutPenalty") val shootOutPenalty: Int,
    @SerializedName("shootOutScore") val shootOutScore: Int,
    @SerializedName("shootPenaltyKick") val shootPenaltyKick: Int,
    @SerializedName("shootTotal") val shootTotal: Int
)