package com.example.geniusgym.member.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.geniusgym.databinding.FragmentMeBodyBinding
import com.example.geniusgym.member.viewmodel.MeBodyViewModel

class MeBodyFragment : Fragment() {
    private lateinit var binding : FragmentMeBodyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 創建一個 MeBodyViewModel 實例，用 viewModels() 函數來創建 ViewModel
       val viewModel: MeBodyViewModel by viewModels()
        binding = FragmentMeBodyBinding.inflate(inflater,container,false)
        // 將 ViewModel 賦值給綁定的 viewModel 變數
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}