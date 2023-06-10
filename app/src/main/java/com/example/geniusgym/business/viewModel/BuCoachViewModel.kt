package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geniusgym.business.model.Branch
import com.example.geniusgym.business.model.Coach
import com.example.geniusgym.business.model.testBuCoach
import com.example.geniusgym.business.model.testBuMember
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class BuCoachViewModel: ViewModel() {
    val branch: MutableLiveData<List<String>> by lazy { MutableLiveData<List<String>>() }
    val coach: MutableLiveData<Coach> by lazy { MutableLiveData<Coach>() }

    fun genToString():String? {
        if (coach.value?.c_gen == 0){
            return "女"
        }
        if (coach.value?.c_gen == 1){
            return "男"
        }
        return null
    }

    fun timeToString():String? {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return coach.value?.c_start_date?.let { format.format(it) }
    }

//    private fun loadBranches() {
//        viewModelScope.launch {
//            branch.value = Branches()
//        }
//    }
//
//    private suspend fun Branches(): List<String> {
//        val url = "http://10.0.2.2:8080/WebRequest_Web/SearchServlet"
//        val jsonObject = JsonObject()
//        jsonObject.addProperty("action", "type")
//        val jsonIn: String = WebRequest().httpPost(url, jsonObject.toString())
//        //匿名內部類別TypeToken
//        val listType = object : TypeToken<List<String?>?>() {}.type
//        return Gson().fromJson(jsonIn, listType)
//    }


}