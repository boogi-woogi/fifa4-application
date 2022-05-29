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
            var shootInBox: Float= 0.1F
            var shootTotal: Float= 0.1F
            var shootOutPenalty: Float= 0.1F
            var longPass: Float= 0.1F
            var shortPass: Float= 0.1F
            var throughPass:Float= 0.1F
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

            binding.boxShoot.text=shootInBox.toString()
            binding.longShoot.text=shootOutPenalty.toString()
            binding.shortPass.text=shortPass.toString()
            binding.avgShoot.text=shootTotal.toString()
            binding.longPass.text=longPass.toString()
        }

    }

}
