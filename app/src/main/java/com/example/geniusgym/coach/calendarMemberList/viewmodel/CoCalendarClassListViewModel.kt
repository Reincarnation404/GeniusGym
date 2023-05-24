package com.example.geniusgym.coach.calendarMemberList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.ClassItem

// 這代表 ClassList 頁面載入時會有的東西
class CoCalendarClassListViewModel : ViewModel() {
    private var itemList = listOf<ClassItem>()
    val items: MutableLiveData<List<ClassItem>> by lazy { MutableLiveData<List<ClassItem>>() }
    init {
        loadItems()
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

    private fun searchItem(item: ClassItem, searchText: String): Boolean {
        return item.date.contains(searchText, ignoreCase = false)
    }

    private fun loadItems(){
        val itemList = mutableListOf<ClassItem>()
        itemList.add(
            ClassItem(
                id = "123",
                startTime = "12:00",
                endTime = "14:00",
                date = "2023-05-25",
                className = "螺璇有氧"
            )
        )
        itemList.add(
            ClassItem(
                id = "456",
                startTime = "13:00",
                endTime = "14:00",
                date = "2023-05-26",
                className = "螺璇有氧"
            )
        )
        this.itemList = itemList
        this.items.value = this.itemList
    }
}
