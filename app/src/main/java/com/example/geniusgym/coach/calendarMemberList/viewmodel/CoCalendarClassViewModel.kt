package com.example.geniusgym.coach.calendarMemberList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.ClassItem
import java.time.LocalDate

class CoCalendarClassViewModel : ViewModel() {
    val textDate: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val Date: MutableLiveData<LocalDate> by lazy { MutableLiveData<LocalDate>() }

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
                id = "1234",
                startTime = "11:00",
                endTime = "12:00",
                date = "2023-06-12",
                className = "螺璇有氧"
            )
        )
        itemList.add(
            ClassItem(
                id = "1231112",
                startTime = "13:00",
                endTime = "14:00",
                date = "2023-06-12",
                className = "突刺有氧"
            )
        )
        itemList.add(
            ClassItem(
                id = "12311111",
                startTime = "13:00",
                endTime = "14:00",
                date = "2023-06-13",
                className = "倒立有氧"
            )
        )
        itemList.add(
            ClassItem(
                id = "456",
                startTime = "15:00",
                endTime = "16:00",
                date = "2023-06-13",
                className = "螺璇有氧"
            )
        )
        itemList.add(
            ClassItem(
                id = "789",
                startTime = "13:00",
                endTime = "14:00",
                date = "2023-06-14",
                className = "螺璇有氧"
            )
        )
        itemList.add(
            ClassItem(
                id = "101112",
                startTime = "15:00",
                endTime = "16:00",
                date = "2023-06-14",
                className = "螺璇有氧"
            )
        )
        itemList.add(
            ClassItem(
                id = "99819923",
                startTime = "10:00",
                endTime = "11:00",
                date = "2023-06-15",
                className = "一對一課程"
            )
        )
        this.itemList = itemList
        this.items.value = this.itemList
    }
}