package com.example.geniusgym.coach.calendarMemberListDetail.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberStaticViewModel
import com.example.geniusgym.R

class CoCalenderMemberStaticFragment : Fragment() {

    companion object {
        fun newInstance() = CoCalenderMemberStaticFragment()
    }

    private lateinit var viewModel: CoCalenderMemberStaticViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_co_calender_member_static, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CoCalenderMemberStaticViewModel::class.java)
        // TODO: Use the ViewModel
    }

}