package com.example.geniusgym.coach.calendarMemberListDetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.ExerciseItem
import java.time.LocalDate

class CoCalenderMemberStaticViewModel : ViewModel() {
    val memberName : MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val memberStatistic : MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val textDate: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val Date: MutableLiveData<LocalDate> by lazy { MutableLiveData<LocalDate>() }
    private var itemList = listOf<ExerciseItem>()
    val items: MutableLiveData<List<ExerciseItem>> by lazy { MutableLiveData<List<ExerciseItem>>() }
    val item: MutableLiveData<ExerciseItem> by lazy { MutableLiveData<ExerciseItem>() }
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
        items.value = searchList
    }

    private fun searchItem(item: ExerciseItem, searchText: String): Boolean {
        return item.sportUpdateTime.contains(searchText, ignoreCase = false)
    }
    private fun load(){
        //TODO
    }
}