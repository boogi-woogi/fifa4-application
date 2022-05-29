package com.example.teamproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject.DataCLass.MatchData
import com.example.teamproject.DataCLass.MatchInfo
import com.example.teamproject.MainActivity.Companion.TAG
import com.example.teamproject.databinding.FragmentOppTotalBinding
import com.example.teamproject.databinding.FragmentRecentTotalBinding
import retrofit2.Response


class RecentTotalFragment : Fragment() {
    var binding: FragmentRecentTotalBinding? = null
    var data: ArrayList<MatchData> = ArrayList()
    var adapter = RecyclerViewAdapter(data)
    private val myViewModel : MyViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRecentTotalBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.clickListener=object:RecyclerViewAdapter.OnItemClickListener{
            override fun ItemClickListener(item: MatchData) {
                item.isClicked=!item.isClicked
            }
        }
        binding!!.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding!!.recyclerView.adapter=adapter
        myViewModel.curMatchData.observe(requireActivity()){
            Log.e(TAG, "onViewCreated: 레아웃변경", )
            adapter.items = it
            adapter.notifyDataSetChanged()
        }

    }

}