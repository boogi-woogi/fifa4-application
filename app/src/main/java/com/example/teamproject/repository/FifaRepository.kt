package com.example.teamproject.repository

import android.util.Log
import com.example.teamproject.DataCLass.MatchData
import com.example.teamproject.DataCLass.UserId
import com.example.teamproject.FifaServiceImp
import com.example.teamproject.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class FifaRepository {


    suspend fun getMatchNumBySearchId(searchId: String) =
        FifaServiceImp.fifaMatch.getMatch(
            value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMzE2MTA4IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMDExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjUwMDoxMCIsIm5iZiI6MTY1MjMxOTUwMCwiZXhwIjoxNjY3ODcxNTAwLCJpYXQiOjE2NTIzMTk1MDB9.K6XEURlQhBdKs_NnXoeZYmwubgx5W3jfb3tFLL27LnY",
            matchtype = 50,
            offset = 0,
            limit = 30,
            useraccessid = FifaServiceImp.fifaUser.getUser(
                value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMzE2MTA4IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMDExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjUwMDoxMCIsIm5iZiI6MTY1MjMxOTUwMCwiZXhwIjoxNjY3ODcxNTAwLCJpYXQiOjE2NTIzMTk1MDB9.K6XEURlQhBdKs_NnXoeZYmwubgx5W3jfb3tFLL27LnY",
                nickname = searchId
            ).body()?.accessId.toString()
        )

    suspend fun getMatchNumBySearchId2(searchId: String) =
        FifaServiceImp.fifaMatch.getMatch(
            value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMzE2MTA4IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMDExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjUwMDoxMCIsIm5iZiI6MTY1MjMxOTUwMCwiZXhwIjoxNjY3ODcxNTAwLCJpYXQiOjE2NTIzMTk1MDB9.K6XEURlQhBdKs_NnXoeZYmwubgx5W3jfb3tFLL27LnY",
            matchtype = 40,
            offset = 0,
            limit = 30,
            useraccessid = FifaServiceImp.fifaUser.getUser(
                value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMzE2MTA4IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMDExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjUwMDoxMCIsIm5iZiI6MTY1MjMxOTUwMCwiZXhwIjoxNjY3ODcxNTAwLCJpYXQiOjE2NTIzMTk1MDB9.K6XEURlQhBdKs_NnXoeZYmwubgx5W3jfb3tFLL27LnY",
                nickname = searchId
            ).body()?.accessId.toString()
        )


    suspend fun getMatchDataByMatchNum(matchNum: List<String>) : ArrayList<MatchData>{
        var data = ArrayList<MatchData>()
        var response_MatchData: Response<MatchData>
        for (i in matchNum) {
            response_MatchData = FifaServiceImp.fifaMatchData.getMatchData(
                value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMzE2MTA4IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMDExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjUwMDoxMCIsIm5iZiI6MTY1MjMxOTUwMCwiZXhwIjoxNjY3ODcxNTAwLCJpYXQiOjE2NTIzMTk1MDB9.K6XEURlQhBdKs_NnXoeZYmwubgx5W3jfb3tFLL27LnY",
                matchid = i
            )
            response_MatchData.body()?.let { data.add(it) }
        }
        return data
    }


}