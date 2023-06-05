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

    init {
        load()
    }
    fun search(input: String?) {
        val searchList = if (input == null || input.isEmpty()) {
            itemList
        } else {
            itemList.filter { item ->
                searchItem(item, input.trim())
            }
        }
        sportRecordBigItems.value = searchList
    }

    private fun searchItem(item: SportRecordBigItem, searchText: String): Boolean {
        return item.time!!.contains(searchText, ignoreCase = true)
    }
    private fun load(){
        /*val exerciseList = mutableListOf<SportRecordItem>()
        memberStatistic.value ="生理性別：戰鬥直升機\n年齡：19\n身高：169 cm\n體重：169 kg\n體脂：40 %"
        exerciseList.add(
            SportRecordItem(
                memberId = "R05221016",
                sportName = "旋轉無養",
                sportUpdateTime = "2023-05-30 23:59:59",
                sportWeight = "100",
                sportFreq = "4",
                sportSet = "3",
                sportCoach = "田聖潔"
            )
        )
        exerciseList.add(
            SportRecordItem(
                memberId = "R05221017",
                sportName = "旋轉有養",
                sportUpdateTime = "2023-05-30 23:59:59",
                sportWeight = "100",
                sportFreq = "4",
                sportSet = "3",
                sportCoach = "聖潔聖潔"
            )
        )

        this.itemList =  exerciseList*/
        val item = this.sportRecordBigLists?.value
        if (item != null) {
            this.itemList = item
            this.sportRecordBigItems.value = this.itemList
        }
    }
}