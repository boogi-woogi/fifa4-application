package com.example.teamproject.DataCLass

import com.google.gson.annotations.SerializedName

data class MatchDetail(
    @SerializedName("averageRating") val averageRating: Double,
    @SerializedName("controller") val controller: String,
    @SerializedName("cornerKick") val cornerKick: Int,
    @SerializedName("dribble") val dribble: Int,
    @SerializedName("foul")val foul: Int,
    @SerializedName("injury")val injury: Int,
    @SerializedName("matchEndType")val matchEndType: Int,
    @SerializedName("matchResult")val matchResult: String,
    @SerializedName("offsideCount")val offsideCount: Int,
    @SerializedName("possession")val possession: Int,
    @SerializedName("redCards")val redCards: Int,
    @SerializedName("seasonId")val seasonId: Int,
    @SerializedName("systemPause")val systemPause: Int,
    @SerializedName("yellowCards")val yellowCards: Int
)