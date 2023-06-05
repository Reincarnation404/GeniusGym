package com.example.geniusgym.coach

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.MemberItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordItem

class CoViewModel : ViewModel() {
    val name: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val member: MutableLiveData<MemberItem> by lazy { MutableLiveData<MemberItem>() }

}