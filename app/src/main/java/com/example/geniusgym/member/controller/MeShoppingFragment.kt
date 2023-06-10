package com.example.geniusgym.member.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeShoppingBinding
import com.example.geniusgym.member.viewmodel.MeShoppingViewModel

class MeShoppingFragment : Fragment() {

    private lateinit var binding : FragmentMeShoppingBinding
//    private val viewModel: MeShoppingViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeShoppingBinding.inflate(LayoutInflater.from(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}