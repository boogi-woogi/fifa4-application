package com.example.teamproject.DataCLass

import com.google.gson.annotations.SerializedName

data class RankData(
    @SerializedName("matchType") val matchType: Int,
    @SerializedName("division")val division: Int,
    @SerializedName("achievementDate")val achievementDate:String
)
