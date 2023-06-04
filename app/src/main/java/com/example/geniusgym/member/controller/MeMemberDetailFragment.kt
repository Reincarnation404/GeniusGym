package com.example.geniusgym.member.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeMemberDetailBinding
import com.example.geniusgym.member.viewmodel.MeMemberDetailViewModel

class MeMemberDetailFragment : Fragment() {
    private lateinit var binding: FragmentMeMemberDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: MeMemberDetailViewModel by viewModels()
        binding = FragmentMeMemberDetailBinding.inflate(inflater, container ,false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}