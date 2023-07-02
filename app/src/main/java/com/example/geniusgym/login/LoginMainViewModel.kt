package com.example.geniusgym.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.business.model.Member
import com.example.geniusgym.member.model.Message
import com.example.geniusgym.sharedata.MeShareData
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import tw.idv.william.androidwebserver.core.service.requestTask

class LoginMainViewModel : ViewModel() {
    val member = Member()
    val result: MutableLiveData<String> by lazy { MutableLiveData<String>() }

//    假資料
    val buAccount = "B123456"
    val buPassword = "1234567"
    val coAccount = "C87632"
    val coPassword = "1234567"
    val meAccount = "M81032"
    val mePassword = "1234567"

    suspend fun melogin() : String{
        var stri = ""
        withContext(Dispatchers.IO){
            member.m_pwd = member.m_pwd.hashCode().toString()
            Log.d("me", member.toString())
            val url = MeShareData.javaWebUrl + "login/*"
            stri = requestTask<JsonObject>(url, "POST", member).toString()
        }
        Log.d("loginaf", stri)
        return getResultFromJson(stri)
    }

    private fun getResultFromJson(str : String) : String{
        val stri = Gson().fromJson(str, Message::class.java)
        Log.d("message", stri.message)
        return stri.message
    }
}