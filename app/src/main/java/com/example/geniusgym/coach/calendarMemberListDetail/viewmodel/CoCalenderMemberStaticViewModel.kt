package com.example.geniusgym.coach.calendarMemberListDetail.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.geniusgym.coach.calendarMemberList.model.MemberItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordBigItem
import com.example.geniusgym.util.WebRequestSpencer
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.time.LocalDate

class CoCalenderMemberStaticViewModel : ViewModel() {
    val memberStatistic: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val textDate: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val date: MutableLiveData<LocalDate> by lazy { MutableLiveData<LocalDate>() }
    var itemList = listOf<SportRecordBigItem>()
    val sportRecordBigItems: MutableLiveData<List<SportRecordBigItem>> by lazy { MutableLiveData<List<SportRecordBigItem>>() }
    val sportRecordBigItem: MutableLiveData<SportRecordBigItem> by lazy { MutableLiveData<SportRecordBigItem>() }
    val member: MutableLiveData<MemberItem> by lazy { MutableLiveData<MemberItem>() }

    fun loadStatistic(context: Context) {
        viewModelScope.launch {
            member?.value?.memberId?.let {
                memberStatisticInfo(it,context)?.let {item->
                    val string = StringBuilder("")
                    memberStatistic.value = string
                        .append("身高： ").append(item.bd_hgt.toString())
                        .append("\n體重： ").append(item.bd_wgt.toString())
                        .append("\n體脂： ").append(item.bd_fat.toString())
                        .toString()
                }
            }
        }
    }


    fun search(id: String?, input: String?) {
        val searchList = if (input == null || input.isEmpty()) {
            itemList
        } else {
            itemList.filter { item ->
                searchItem(id!!, item, input.trim())
            }
        }
        sportRecordBigItems.value = searchList
    }

    private fun searchItem(id: String, item: SportRecordBigItem, searchText: String): Boolean {
        return item.time!!.contains(searchText, ignoreCase = true) &&
                item.m_id!!.contains(id, ignoreCase = true)
    }

    fun load(item: MutableList<SportRecordBigItem>) {
        this.itemList = item
        this.sportRecordBigItems.value = this.itemList
    }

    private suspend fun memberStatisticInfo(memberId: String, context: Context): BodyData? {
        val jsonObject = JsonObject()
        jsonObject.addProperty("m_id", memberId)
        val jsonIn: String = WebRequestSpencer().httpPost("GetMemberStatic", jsonObject.toString())
        return if (jsonIn == "ConnectError" || jsonIn == "") {
            Toast.makeText(context,"連線失敗",Toast.LENGTH_SHORT).show()
            null
        } else {
            val type = object : TypeToken<BodyData?>() {}.type
            Gson().fromJson(jsonIn, type)
        }
    }

    class BodyData(
        var bd_id: Int,
        var m_id: String,
        var bd_hgt: Float,
        var bd_wgt: Float,
        var bd_fat: Float
    )
}