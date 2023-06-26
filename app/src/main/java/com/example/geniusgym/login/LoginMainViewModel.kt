package com.example.geniusgym.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geniusgym.business.model.Member
import com.example.geniusgym.factory.WebFactory
import com.example.geniusgym.member.model.Message
import com.example.geniusgym.util.WebRequestSpencer
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

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
            val request = WebFactory().craete() as WebRequestSpencer
            val str = Gson().toJson(member)
            Log.d("me", member.toString())
            stri = request.httpPost("login/*", str)
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