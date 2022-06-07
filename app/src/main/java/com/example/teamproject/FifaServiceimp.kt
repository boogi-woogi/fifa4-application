package com.example.teamproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FifaServiceImp {
    private const val BASE_URL = "https://api.nexon.co.kr"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val fifaUser = retrofit.create(FifaUser::class.java)
    val fifaMatch = retrofit.create(FifaMatch::class.java)
    val fifaMatchData= retrofit.create(FifaMatchData::class.java)
    val fifaRank= retrofit.create(FifaRank::class.java)
}