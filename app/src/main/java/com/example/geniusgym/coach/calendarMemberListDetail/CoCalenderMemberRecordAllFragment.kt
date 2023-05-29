package com.example.geniusgym.coach.calendarMemberListDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.geniusgym.R

/**
 * A simple [Fragment] subclass.
 * Use the [CoCalenderMemberRecordAllFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CoCalenderMemberRecordAllFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_co_calender_member_record_all, container, false)
    }


}