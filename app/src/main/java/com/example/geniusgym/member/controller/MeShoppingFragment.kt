package com.example.geniusgym.member.controller

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeShoppingBinding
import com.example.geniusgym.member.adapter.MeShoppingAdapter
import com.example.geniusgym.member.viewmodel.MeShoppingViewModel
import com.example.geniusgym.sharedata.MeShareData

class MeShoppingFragment : Fragment() {

    private lateinit var binding : FragmentMeShoppingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: MeShoppingViewModel = ViewModelProvider(this)[MeShoppingViewModel::class.java]
        binding = FragmentMeShoppingBinding.inflate(LayoutInflater.from(requireContext()))
        binding.viewModel = viewModel
        viewModel.update()
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("test2", MeShareData.branchName)
        with(binding){
            viewModel?.branchName?.value = MeShareData.branchName
            meShoppingRecycle.layoutManager = LinearLayoutManager(requireContext())
            meShoppingRecycle.adapter = viewModel!!.shopitems.let {
                Log.d( "adapter", it.toString())
                MeShoppingAdapter(
                    it
                )
            }
        }
    }

    private fun setMenu(){
        
    }

}