package com.example.geniusgym

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.geniusgym.coach.calendarMemberList.model.MemberInfo

class LoginMainViewModel : ViewModel() {
    val member: MutableLiveData<MemberInfo> by lazy { MutableLiveData<MemberInfo>(MemberInfo()) }
    val result: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}