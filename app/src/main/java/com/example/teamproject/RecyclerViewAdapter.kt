package com.example.teamproject

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject.DataCLass.MatchData
import com.example.teamproject.databinding.FragmentItemBinding
import com.example.teamproject.databinding.RowBinding
import retrofit2.Response

class RecyclerViewAdapter(var items: ArrayList<MatchData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: FragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.resultrow.setOnClickListener {
                clickListener?.ItemClickListener(items[adapterPosition])
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    interface OnItemClickListener {
        fun ItemClickListener(item: MatchData)
    }

    var clickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var cur_user:String?=null

        if( (items[0].matchInfo.get(0).nickname==items[1].matchInfo.get(0).nickname)
            ||(items[0].matchInfo.get(0).nickname==items[1].matchInfo.get(1).nickname) ) cur_user=items[0].matchInfo.get(0).nickname

        if( (items[0].matchInfo.get(1).nickname==items[1].matchInfo.get(0).nickname)
            ||(items[0].matchInfo.get(1).nickname==items[1].matchInfo.get(1).nickname) ) cur_user=items[0].matchInfo.get(1).nickname


        val user1 = items[position].matchInfo[0].nickname.toString()
        val user2 = items[position].matchInfo[1].nickname.toString()


        holder.binding.resultrow.text = user1 + " VS " + user2
        holder.binding.score.text = user1+" "+items[position].matchInfo[0].shoot.goalTotal.toString()+" : "+items[position].matchInfo[1].shoot.goalTotal.toString()+" "+user2
//        holder.binding.resultrow.setBackgroundColor()


        if(cur_user==items[position].matchInfo[0].nickname&&items[position].matchInfo[0].matchDetail.matchResult=="패") holder.binding.resultrow.setBackgroundColor(
            Color.parseColor("#FFEEEE"))
        if(cur_user==items[position].matchInfo[0].nickname&&items[position].matchInfo[0].matchDetail.matchResult=="승") holder.binding.resultrow.setBackgroundColor(
            Color.parseColor("#D4E4FE"))

        if(cur_user==items[position].matchInfo[1].nickname){
            if(items[position].matchInfo[1].matchDetail.matchResult=="패")
                holder.binding.resultrow.setBackgroundColor(Color.parseColor("#FFEEEE"))
            else if(items[position].matchInfo[1].matchDetail.matchResult=="승")
                holder.binding.resultrow.setBackgroundColor(Color.parseColor("#D4E4FE"))
        }
        if(cur_user==items[position].matchInfo[1].nickname&&items[position].matchInfo[1].matchDetail.matchResult=="승") holder.binding.resultrow.setBackgroundColor(
            Color.parseColor("#D4E4FE"))

        Log.i("ffffffffffffffffffff", cur_user!!)



        holder.binding.user1Detail.text =
            "페널티 박스 안에서의 슛 : " + items[position].matchInfo[0].shoot.goalInPenalty.toString() + "/" + items[position].matchInfo[0].shoot.shootInPenalty.toString() + '\n' +
                    "중거리 슛 : " + items[position].matchInfo[0].shoot.goalOutPenalty.toString() + "/" + items[position].matchInfo[0].shoot.shootInPenalty.toString() + '\n' +
                    "헤딩 슛: " + items[position].matchInfo[0].shoot.goalHeading.toString() + "/" + items[position].matchInfo[0].shoot.shootHeading.toString() + '\n' +
                    "짧은 패스 : " + items[position].matchInfo[0].pass.shortPassSuccess.toString() + "/" + items[position].matchInfo[0].pass.shortPassTry.toString() + '\n' +
                    "긴 패스 : " + items[position].matchInfo[0].pass.longPassSuccess.toString() + "/" + items[position].matchInfo[0].pass.longPassTry.toString()

        holder.binding.user2Detail.text =
            "페널티 박스 안에서의 슛 : " + items[position].matchInfo[1].shoot.goalInPenalty.toString() + "/" + items[position].matchInfo[1].shoot.shootInPenalty.toString() + '\n' +
                    "중거리 슛 : " + items[position].matchInfo[1].shoot.goalOutPenalty.toString() + "/" + items[position].matchInfo[1].shoot.shootInPenalty.toString() + '\n' +
                    "헤딩 슛: " + items[position].matchInfo[1].shoot.goalHeading.toString() + "/" + items[position].matchInfo[1].shoot.shootHeading.toString() + '\n' +
                    "짧은 패스 : " + items[position].matchInfo[1].pass.shortPassSuccess.toString() + "/" + items[position].matchInfo[1].pass.shortPassTry.toString() + '\n' +
                    "긴 패스 : " + items[position].matchInfo[1].pass.longPassSuccess.toString() + "/" + items[position].matchInfo[1].pass.longPassTry.toString()


        if (!items[position].isClicked) holder.binding.resultDetail.visibility = View.GONE
        else holder.binding.resultDetail.visibility = View.VISIBLE
    }

    override fun getItemCount(): Int = items.size


}