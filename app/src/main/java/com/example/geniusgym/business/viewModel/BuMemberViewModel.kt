package com.example.geniusgym.business.viewModel

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.business.model.Member
import com.example.geniusgym.business.model.testBuMember
import com.google.gson.reflect.TypeToken
import tw.idv.william.androidwebserver.core.service.requestTask

class BuMemberViewModel: ViewModel() {
    val url = "http://10.0.2.2:8080/geniusgym_bg/"
    val member: MutableLiveData<Member> by lazy { MutableLiveData<Member>() }
    val list: MutableLiveData<List<Member>> by lazy { MutableLiveData<List<Member>>() }

//    fun inti(){
//        val type = object : TypeToken<List<Member>>() {}.type
//        list.value = requestTask<List<Member>>(url, respBodyType = type)
//    }

    fun genToString():String? {
        if (member.value?.m_gen == 0){
           return "女"
        }
        if (member.value?.m_gen == 1){
            return "男"
        }
        return null
    }
}