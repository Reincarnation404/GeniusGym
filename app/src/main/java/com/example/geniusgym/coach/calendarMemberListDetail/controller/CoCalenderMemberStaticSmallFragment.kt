package com.example.geniusgym.coach.calendarMemberListDetail.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberStaticSmallViewModel
import com.example.geniusgym.databinding.FragmentCoCalenderMemberStaticSmallBinding

class CoCalenderMemberStaticSmallFragment : Fragment() {
    private lateinit var binding: FragmentCoCalenderMemberStaticSmallBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel : CoCalenderMemberStaticSmallViewModel by viewModels()
        binding = FragmentCoCalenderMemberStaticSmallBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}