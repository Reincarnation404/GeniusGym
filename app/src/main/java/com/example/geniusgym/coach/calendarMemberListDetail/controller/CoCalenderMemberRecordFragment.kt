package com.example.geniusgym.coach.calendarMemberListDetail.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberRecordViewModel
import com.example.geniusgym.R

class CoCalenderMemberRecordFragment : Fragment() {

    companion object {
        fun newInstance() = CoCalenderMemberRecordFragment()
    }

    private lateinit var viewModel: CoCalenderMemberRecordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_co_calender_member_record, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CoCalenderMemberRecordViewModel::class.java)
        // TODO: Use the ViewModel
    }

}