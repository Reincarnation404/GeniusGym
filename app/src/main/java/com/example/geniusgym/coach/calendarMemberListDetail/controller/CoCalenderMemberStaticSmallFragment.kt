package com.example.geniusgym.coach.calendarMemberListDetail.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberStaticSmallViewModel

class CoCalenderMemberStaticSmallFragment : Fragment() {

    companion object {
        fun newInstance() = CoCalenderMemberStaticSmallFragment()
    }

    private lateinit var viewModel: CoCalenderMemberStaticSmallViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_co_calender_member_static_small, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CoCalenderMemberStaticSmallViewModel::class.java)
        // TODO: Use the ViewModel
    }

}