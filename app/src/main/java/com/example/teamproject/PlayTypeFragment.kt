package com.example.teamproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.teamproject.MainActivity.Companion.TAG
import com.example.teamproject.databinding.FragmentPlayTypeBinding
import kotlin.math.round

// TODO: Rename parameter arguments, choose names that matc
class PlayTypeFragment : Fragment() {
    val myViewModel: MyViewModel by activityViewModels()
    lateinit var binding:FragmentPlayTypeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentPlayTypeBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        myViewModel.UserId.observe(requireActivity()) {
//
//        }
        myViewModel.curMatchData.observe(requireActivity()){
            var shootInBox: Float= 0.0F
            var shootTotal: Float= 0.0F
            var shootOutPenalty: Float= 0.0F
            var longPass: Float= 0.0F
            var shortPass: Float= 0.0F
            var throughPass:Float= 0.0F
            for (i in myViewModel.curMatchData.value!!) {
                for (j in i.matchInfo) {
                    if (myViewModel.UserId.value == j.nickname) {
                        shootInBox += j.shoot.shootInPenalty
                        shootTotal += j.shoot.shootTotal
                        shootOutPenalty += j.shoot.shootOutPenalty
                        longPass += j.pass.longPassTry
                        shortPass += j.pass.shortPassTry
                        throughPass+=j.pass.lobbedThroughPassTry + j.pass.throughPassTry
                    }
                }
            }
            shootInBox/=30
            shootTotal/=30
            shootOutPenalty/=30
            longPass/=30
            shortPass/=30
            throughPass/=30

            binding.boxShoot.text=round((shootInBox*10)/10).toString()
            binding.longShoot.text=round((shootOutPenalty*10)/10).toString()
            binding.shortPass.text=round((shortPass*10)/10).toString()
            binding.avgShoot.text=round((shootTotal*10)/10).toString()
            binding.longPass.text=round((longPass*10)/10).toString()
        }

    }

}
