package com.example.geniusgym

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.LoginMemberItem
import java.util.function.BinaryOperator

class LoginMainViewModel : ViewModel() {
    val member: MutableLiveData<LoginMemberItem> by lazy { MutableLiveData<LoginMemberItem>() }
    val result: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    var account = "xxx"
    var password = "xxx"

//    假資料
    val buAccount = "b123456"
    val buPassword = "1234567"
    val coAccount = "c123456"
    val coPassword = "1234567"
    val meAccount = "m123456"
    val mePassword = "1234567"

//    fun requireBusiness() : Boolean{
//
//
//    }
//
//    fun requireMember() : Boolean{
//
//    }
//
//    fun requireCoach() : Boolean {
//
//    }

}