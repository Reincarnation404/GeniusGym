package com.example.geniusgym

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.LoginMemberItem

class LoginMainViewModel : ViewModel() {
    val member: MutableLiveData<LoginMemberItem> by lazy { MutableLiveData<LoginMemberItem>() }
    val result: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}