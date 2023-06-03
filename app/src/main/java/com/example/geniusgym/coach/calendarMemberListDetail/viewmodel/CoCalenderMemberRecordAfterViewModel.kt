package com.example.geniusgym.coach.calendarMemberListDetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportSmallItem

class CoCalenderMemberRecordAfterViewModel: ViewModel() {
    val item : MutableLiveData<SportSmallItem> by lazy { MutableLiveData<SportSmallItem>() }
}