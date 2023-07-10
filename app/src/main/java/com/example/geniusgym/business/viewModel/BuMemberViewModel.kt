package com.example.geniusgym.business.viewModel

import android.app.AlertDialog
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.business.model.Member
import com.example.geniusgym.sharedata.MeShareData
import com.google.gson.JsonObject
import com.example.geniusgym.business.core.service.requestTask
import java.text.SimpleDateFormat
import java.util.*

class BuMemberViewModel: ViewModel() {
    val url = MeShareData.javaWebUrl + "buMember"


    val member: MutableLiveData<Member> by lazy { MutableLiveData<Member>() }
    val list: MutableLiveData<List<Member>> by lazy { MutableLiveData<List<Member>>() }


    fun genToString():String? {
        if (member.value?.m_gen == 0){
           return "女"
        }
        if (member.value?.m_gen == 1){
            return "男"
        }
        return null
    }

    fun timeToString():String? {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return member.value?.m_ed_date?.let { format.format(it) }
    }

    fun Suspend(view: View){
        if (member.value!!.m_sus == true) {
            AlertDialog.Builder(view.context)
                .setMessage("確定將此用戶停權?")
                .setPositiveButton("是") { _, _ ->
                    member.value.run {
                        requestTask<JsonObject>(url, "DELETE", member.value)
                        println(member.value)
                        Navigation.findNavController(view).navigate(R.id.buMemberDataFragment)
                    }
                }
                .setCancelable(true)
                .show()
        }else{AlertDialog.Builder(view.context)
            .setMessage("確定將此用戶解除停權?")
            .setPositiveButton("是") { _, _ ->
                member.value.run {
                    requestTask<JsonObject>(url, "DELETE", member.value)
                    println(member.value)
                    Navigation.findNavController(view).navigate(R.id.buMemberDataFragment)
                }
            }
            .setCancelable(true)
            .show()}
        true
    }
}