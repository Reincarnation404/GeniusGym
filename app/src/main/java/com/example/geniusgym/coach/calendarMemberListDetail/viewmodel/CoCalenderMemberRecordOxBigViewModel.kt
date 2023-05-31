package com.example.geniusgym.coach.calendarMemberListDetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportBigItem

class CoCalenderMemberRecordOxBigViewModel : ViewModel() {
    val items: MutableLiveData<List<SportBigItem>> by lazy { MutableLiveData<List<SportBigItem>>() }
    val item: MutableLiveData<SportBigItem> by lazy { MutableLiveData<SportBigItem>() }


}