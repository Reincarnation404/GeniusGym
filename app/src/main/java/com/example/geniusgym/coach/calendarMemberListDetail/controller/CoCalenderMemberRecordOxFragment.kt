package com.example.geniusgym.coach.calendarMemberListDetail.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberRecordOxBigViewModel
import com.example.geniusgym.databinding.FragmentCoCalenderMemberRecordOxBinding


class CoCalenderMemberRecordOxFragment : Fragment() {
    private lateinit var binding: FragmentCoCalenderMemberRecordOxBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val viewmodel : CoCalenderMemberRecordOxBigViewModel by viewModels()
        binding = FragmentCoCalenderMemberRecordOxBinding.inflate(inflater, container, false)
        binding.viewModel = viewmodel
        binding.lifecycleOwner = this
        return binding.root
    }


}