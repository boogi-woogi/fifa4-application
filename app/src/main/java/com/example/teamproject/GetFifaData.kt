package com.example.teamproject

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface FifaUser {
    @GET("/fifaonline4/v1.0/users")
    suspend fun getUser(
        @Header("Authorization") value: String,
        @Query("nickname") nickname : String
    ): Response<UserId>
}

interface FifaMatch{
    @GET("fifaonline4/v1.0/users/{user_accessid}/matches")
    suspend fun getMatch(
        @Header("Authorization") value: String,
        @Path("user_accessid") useraccessid: String,
        @Query("matchtype") matchtype : Int,
        @Query("offset") offset : Int,
        @Query("limit") limit : Int,
    ): List<String>
}

interface FifaMatchData{
    @GET("/fifaonline4/v1.0/matches/{matchid}")
    suspend fun getMatchData(
        @Header("Authorization") value: String,
        @Path("matchid") matchid: String,
    ): Response<MatchData>
}