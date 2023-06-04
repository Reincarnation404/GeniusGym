package com.example.geniusgym.coach.calendarMemberListDetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.MemberItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportSmallItem

class CoCalenderMemberRecordAfterViewModel : ViewModel() {
    val recordItems: MutableLiveData<List<SportRecordItem>> by lazy { MutableLiveData<List<SportRecordItem>>() }
    val recordItem: MutableLiveData<SportRecordItem> by lazy { MutableLiveData<SportRecordItem>() }
    val item: MutableLiveData<SportSmallItem> by lazy { MutableLiveData<SportSmallItem>() }
    val member: MutableLiveData<MemberItem> by lazy { MutableLiveData<MemberItem>() }
    val name: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val sportName: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    var sc_id: String = ""
    var m_id: String = ""

    init {
        load()
    }

    private fun load() {
        recordItems.value = arrayListOf()
    }

    fun onClick() {
        val item = 1
    }
}