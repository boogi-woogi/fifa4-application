package com.example.teamproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject.DataCLass.MatchData
import com.example.teamproject.DataCLass.MatchInfo
import retrofit2.Response


class RecentTotalFragment : Fragment() {
    var data: ArrayList<Response<MatchData>> = ArrayList()
    var adapter = RecyclerViewAdapter(data)



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recent_total, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter.itemClickListener = object :RecyclerViewAdapter.OnItemClickListener{
            override fun OnItemClick(data:Response<MatchData>, position: Int) {
                data.body()!!.isClicked = !data.body()!!.isClicked
                adapter.notifyItemChanged(position)
            }
        }
        recyclerView.adapter = adapter

        return view

    }

}