package com.example.teamproject

import com.google.gson.annotations.SerializedName

data class UserId(
    @SerializedName("accessId") val accessId: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("level") val level	: Int,
)