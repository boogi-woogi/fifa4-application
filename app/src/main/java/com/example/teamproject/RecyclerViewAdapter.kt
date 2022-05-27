package com.example.teamproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject.DataCLass.MatchData
import com.example.teamproject.databinding.FragmentItemBinding
import com.example.teamproject.databinding.RowBinding
import retrofit2.Response

class RecyclerViewAdapter(val items:ArrayList<Response<MatchData>>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    interface OnItemClickListener{
        fun OnItemClick(data: Response<MatchData>, position: Int)
    }

    var itemClickListener:OnItemClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user1 = items[position].body()!!.matchInfo[0].nickname.toString()
        val res1 = items[position].body()!!.matchInfo[0].matchDetail.matchResult.toString()
        val score1 = items[position].body()!!.matchInfo[0].shoot.goalTotal.toString()

        val user2 = items[position].body()!!.matchInfo[1].nickname.toString()
        val res2 = items[position].body()!!.matchInfo[1].matchDetail.matchResult.toString()
        val score2 = items[position].body()!!.matchInfo[1].shoot.goalTotal.toString()


        holder.binding.resultrow.text = user1 + " VS " + user2
        holder.binding.user1Nickname.text = user1
        holder.binding.user2Nickname.text = user2

        holder.binding.user1Detail.text =
            "페널티 박스 안에서의 슛 : " + items[position].body()!!.matchInfo[0].shoot.goalInPenalty.toString() + "/" + items[position].body()!!.matchInfo[0].shoot.shootInPenalty.toString() + '\n' +
                    "중거리 슛 : " + items[position].body()!!.matchInfo[0].shoot.goalOutPenalty.toString() + "/" + items[position].body()!!.matchInfo[0].shoot.shootInPenalty.toString() + '\n' +
                    "헤딩 슛: " + items[position].body()!!.matchInfo[0].shoot.goalHeading.toString() + "/" + items[position].body()!!.matchInfo[0].shoot.shootHeading.toString() + '\n' +
                    "짧은 패스 : " + items[position].body()!!.matchInfo[0].pass.shortPassSuccess.toString() + "/" + items[position].body()!!.matchInfo[0].pass.shortPassTry.toString() + '\n' +
                    "긴 패스 : " + items[position].body()!!.matchInfo[0].pass.longPassSuccess.toString() + "/" + items[position].body()!!.matchInfo[0].pass.longPassTry.toString()

        holder.binding.user2Detail.text =
            "페널티 박스 안에서의 슛 : " + items[position].body()!!.matchInfo[1].shoot.goalInPenalty.toString() + "/" + items[position].body()!!.matchInfo[1].shoot.shootInPenalty.toString() + '\n' +
                    "중거리 슛 : " + items[position].body()!!.matchInfo[1].shoot.goalOutPenalty.toString() + "/" + items[position].body()!!.matchInfo[1].shoot.shootInPenalty.toString() + '\n' +
                    "헤딩 슛: " + items[position].body()!!.matchInfo[1].shoot.goalHeading.toString() + "/" + items[position].body()!!.matchInfo[1].shoot.shootHeading.toString() + '\n' +
                    "짧은 패스 : " + items[position].body()!!.matchInfo[1].pass.shortPassSuccess.toString() + "/" + items[position].body()!!.matchInfo[1].pass.shortPassTry.toString() + '\n' +
                    "긴 패스 : " + items[position].body()!!.matchInfo[1].pass.longPassSuccess.toString() + "/" + items[position].body()!!.matchInfo[1].pass.longPassTry.toString()


        if(!items[position].body()!!.isClicked){
            holder.binding.resultDetail.visibility = View.GONE
        }else
            holder.binding.resultDetail.visibility = View.VISIBLE

    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.resultrow.setOnClickListener {
                itemClickListener?.OnItemClick(items[adapterPosition], adapterPosition)

            }
        }
    }
}