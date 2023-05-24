package com.example.geniusgym.coach

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberList.viewmodel.CoCalendarMemberDetailViewModel

class CoCalendarMemberDetailFragment : Fragment() {

    companion object {
        fun newInstance() = CoCalendarMemberDetailFragment()
    }

    private lateinit var viewModel: CoCalendarMemberDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_co_calendar_member_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CoCalendarMemberDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}