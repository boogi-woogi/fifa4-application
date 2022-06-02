package com.example.teamproject

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamproject.DataCLass.MatchData
import com.example.teamproject.DataCLass.UserId
import com.example.teamproject.repository.FifaRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MyViewModel(private val fifaRepository: FifaRepository) : ViewModel() {
    var data = mutableListOf<ArrayList<Response<MatchData>>>()
    var UserId = MutableLiveData<String>()
    val curMatchNum = MutableLiveData<List<String>>()
    val curMatchNum2 = MutableLiveData<List<String>>()
    var curMatchData = MutableLiveData<ArrayList<MatchData>>()
    var curMatchData2= MutableLiveData<ArrayList<MatchData>>()
    var stateProgressbar = MutableLiveData<Boolean>()



    fun getUserIdBySearchId(searchId: String) = viewModelScope.launch {
        UserId.value=searchId
        stateProgressbar.value=true
        fifaRepository.getMatchNumBySearchId(searchId).let {
            curMatchNum.postValue(it)
        }
    }

    fun getUserIdBySearchId2(searchId: String) = viewModelScope.launch {
        UserId.value=searchId
        stateProgressbar.value=true
        fifaRepository.getMatchNumBySearchId2(searchId).let {
            curMatchNum2.postValue(it)
        }
    }

    fun getMatchDataByMatchNum(matchNum: List<String>) = viewModelScope.launch {
        fifaRepository.getMatchDataByMatchNum(matchNum).let{
            curMatchData.postValue(it)
            stateProgressbar.value=false
//            Log.e("어디가", "문젱")
        }
    }


    fun getMatchDataByMatchNum2(matchNum: List<String>) = viewModelScope.launch {
        fifaRepository.getMatchDataByMatchNum(matchNum).let{
            curMatchData2.postValue(it)
            stateProgressbar.value=false
//            Log.e("어디가", "문젱")
        }
    }
}


