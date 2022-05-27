package com.example.teamproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject.DataCLass.MatchData
import com.example.teamproject.databinding.FragmentItemBinding
import com.example.teamproject.databinding.RowBinding
import retrofit2.Response

class RecyclerViewAdapter2(val items:ArrayList<OppData>): RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            RowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter2.ViewHolder, position: Int){
        holder.binding.nickname.text = items[position].data
        holder.binding.total.text = items[position].opptotal

    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: RowBinding) : RecyclerView.ViewHolder(binding.root){

    }

}