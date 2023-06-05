package com.example.geniusgym.coach.calendarMemberListDetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.CoActivity

import com.example.geniusgym.coach.calendarMemberList.model.MemberItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordBigItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordItem
import java.time.LocalDate

class CoCalenderMemberStaticViewModel : ViewModel() {
    val memberStatistic : MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val textDate: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val date: MutableLiveData<LocalDate> by lazy { MutableLiveData<LocalDate>() }
    var itemList = listOf<SportRecordBigItem>()
    val sportRecordBigItems: MutableLiveData<List<SportRecordBigItem>> by lazy { MutableLiveData<List<SportRecordBigItem>>() }
    val sportRecordBigLists: MutableLiveData<List<SportRecordBigItem>> by lazy { MutableLiveData<List<SportRecordBigItem>>() }
    val sportRecordBigItem: MutableLiveData<SportRecordBigItem> by lazy { MutableLiveData<SportRecordBigItem>() }
    private var exerciseLists = listOf<SportRecordItem>()
    val member: MutableLiveData<MemberItem> by lazy { MutableLiveData<MemberItem>() }


    fun search(id:String?,input: String?) {
        val searchList = if (input == null || input.isEmpty()) {
            itemList
        } else {
            itemList.filter { item ->
                searchItem(id!!,item, input.trim())
            }
        }
        sportRecordBigItems.value = searchList
    }

    private fun searchItem(id:String, item: SportRecordBigItem, searchText: String): Boolean {
        return item.time!!.contains(searchText, ignoreCase = true) &&
                item.m_id!!.contains(id,ignoreCase = true)
    }
    fun load(item : MutableList<SportRecordBigItem>){
            this.itemList = item
            this.sportRecordBigItems.value = this.itemList
    }
}