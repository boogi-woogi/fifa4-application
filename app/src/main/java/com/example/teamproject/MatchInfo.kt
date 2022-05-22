package com.example.teamproject

import com.google.gson.annotations.SerializedName

data class MatchInfo(
    @SerializedName("accessId") val accessId: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("matchDetail") val matchDetail: MatchDetail,
    @SerializedName("shoot") val shoot: Shoot,
    @SerializedName("shootDetail") val shootDetail: List<ShootDetail>,
    @SerializedName("pass") val pass: Pass,
    @SerializedName("defence") val defence: Defence,
    @SerializedName("player") val player: List<Player>


    )