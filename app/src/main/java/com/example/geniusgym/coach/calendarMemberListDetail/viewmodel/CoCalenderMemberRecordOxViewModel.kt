package com.example.geniusgym.coach.calendarMemberListDetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportSmallItem

class CoCalenderMemberRecordOxViewModel : ViewModel() {
    val items: MutableLiveData<List<SportSmallItem>> by lazy { MutableLiveData<List<SportSmallItem>>() }
    val item: MutableLiveData<SportSmallItem> by lazy { MutableLiveData<SportSmallItem>() }

    init {
        load()
    }


    private fun load() {
        val items = mutableListOf<SportSmallItem>()

        items.add(SportSmallItem("1", "1", "飛輪"))
        items.add(SportSmallItem("1", "2", "靜態"))
        items.add(SportSmallItem("1", "3", "心肺訓練"))
        items.add(SportSmallItem("1", "4", "跑步"))
        items.add(SportSmallItem("1", "5", "舞蹈"))

        this.items.value = items
    }
}