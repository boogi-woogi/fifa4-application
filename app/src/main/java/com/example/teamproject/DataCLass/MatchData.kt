package com.example.teamproject.DataCLass

import com.google.gson.annotations.SerializedName

data class MatchData(
    @SerializedName("matchId") val matchId: String,
    @SerializedName("matchDate") val matchDate: String,
    @SerializedName("matchType") val matchType: Int,
    @SerializedName("matchInfo") val matchInfo: List<MatchInfo>,
    val isClicked:Boolean=false
)