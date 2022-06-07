package com.example.teamproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject.DataCLass.MatchData
import com.example.teamproject.databinding.FragmentItemBinding
import com.example.teamproject.databinding.OppRowBinding
import com.example.teamproject.databinding.RowBinding
import retrofit2.Response

class RecyclerViewAdapter2(var items:ArrayList<OppData>): RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(OppRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter2.ViewHolder, position: Int){
        holder.binding.textView11.text = items[position].nickName
        holder.binding.textView12.text = items[position].opptotal.get(0).toString()+"승 "+items[position].opptotal.get(1).toString()+"패"
    }

    override fun getItemCount(): Int = items.size


    inner class ViewHolder(val binding: OppRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

}