package com.example.teamproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamproject.DataCLass.MatchData
import com.example.teamproject.DataCLass.UserId
import com.example.teamproject.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: Adapter
    var data=ArrayList<Response<MatchData>>()
    companion object {
        const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        binding.apply{
            sendBtn.setOnClickListener {
                val searchId = binding.editText.text.toString()
                unofficial_game_serach(searchId)
            }
        }
    }
    private fun initRecyclerView() {
        adapter= Adapter(data)
        binding.recyclerView.layoutManager= LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.adapter=adapter
    }
    private fun unofficial_game_serach(searchId: String) {
        data.clear()
        CoroutineScope(Dispatchers.Main).launch {
            var response_User: Response<UserId>
            var response_MatchNum: List<String>
            var response_MatchData: Response<MatchData>
            binding.recyclerView.visibility=View.GONE
            binding.progressBar.visibility= View.VISIBLE
            withContext(Dispatchers.IO) {
                response_User = FifaServiceImp.fifaUser.getUser(
                    value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMzE2MTA4IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMDExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjUwMDoxMCIsIm5iZiI6MTY1MjMxOTUwMCwiZXhwIjoxNjY3ODcxNTAwLCJpYXQiOjE2NTIzMTk1MDB9.K6XEURlQhBdKs_NnXoeZYmwubgx5W3jfb3tFLL27LnY",
                    nickname = searchId
                )
                if (response_User.body() != null) {
                    val user_accessid: String? = response_User.body()?.accessId
                    if (user_accessid != null) {
                        response_MatchNum = FifaServiceImp.fifaMatch.getMatch(
                            value = application.getString(R.string.fifa_api_key),
                            useraccessid = user_accessid,
                            matchtype = 40,
                            offset = 0,
                            limit = 10
                        )

                        if (response_MatchNum.size != 0) {
                            for (i in response_MatchNum) {
                                Log.i("match num : ", i)
                                response_MatchData =
                                    FifaServiceImp.fifaMatchData.getMatchData(
                                        value = application.getString(R.string.fifa_api_key),
                                        matchid = i
                                    )
                                data.add(response_MatchData)
                                for (j in response_MatchData.body()?.matchInfo!!) {
                                    if (j.accessId == user_accessid) {
                                        Log.i("${j.nickname.toString()}", "${j.matchDetail.matchResult.toString()}")
                                    }
                                    else{
                                        Log.i("${j.nickname.toString()}", "${j.matchDetail.matchResult.toString()}")
                                    }
                                }
                            }
                        } else {
                            Log.i("검색된 데이터가 없습니다.", "")
                        }
                    }
                }
            }
            binding.progressBar.visibility= View.GONE
            binding.recyclerView.visibility=View.VISIBLE
            adapter.notifyDataSetChanged()
        }

    }
    private fun official_game_serach(searchId: String) {
        CoroutineScope(Dispatchers.Main).launch {
            var response_User: Response<UserId>
            var response_MatchNum: List<String>
            var response_MatchData: Response<MatchData>

            withContext(Dispatchers.IO) {
                response_User = FifaServiceImp.fifaUser.getUser(
                    value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMzE2MTA4IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMDExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjUwMDoxMCIsIm5iZiI6MTY1MjMxOTUwMCwiZXhwIjoxNjY3ODcxNTAwLCJpYXQiOjE2NTIzMTk1MDB9.K6XEURlQhBdKs_NnXoeZYmwubgx5W3jfb3tFLL27LnY",
                    nickname = searchId
                )
                if (response_User.body() != null) {
                    val user_accessid: String? = response_User.body()?.accessId
                    if (user_accessid != null) {
                        response_MatchNum = FifaServiceImp.fifaMatch.getMatch(
                            value = application.getString(R.string.fifa_api_key),
                            useraccessid = user_accessid,
                            matchtype = 50,
                            offset = 0,
                            limit = 10
                        )

                        if (response_MatchNum.size != 0) {
                            for (i in response_MatchNum) {
                                Log.i("match num : ", i)
                                response_MatchData =
                                    FifaServiceImp.fifaMatchData.getMatchData(
                                        value = application.getString(R.string.fifa_api_key),
                                        matchid = i
                                    )
                                for (j in response_MatchData.body()?.matchInfo!!) {
                                    if (j.accessId == user_accessid) {
                                        Log.i("총 슈팅 수", "${j.shoot.shootTotal.toString()}")
                                    }
                                }
                            }
                        } else {
                            Log.i("검색된 데이터가 없습니다.", "")
                        }
                    }
                }
            }
        }
    }
}
