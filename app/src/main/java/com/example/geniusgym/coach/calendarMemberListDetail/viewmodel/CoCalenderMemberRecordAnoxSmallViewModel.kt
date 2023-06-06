package com.example.geniusgym.coach.calendarMemberListDetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportSmallItem

class CoCalenderMemberRecordAnoxSmallViewModel : ViewModel() {
    val items: MutableLiveData<List<SportSmallItem>> by lazy { MutableLiveData<List<SportSmallItem>>() }
    val item: MutableLiveData<SportSmallItem> by lazy { MutableLiveData<SportSmallItem>() }
    private var itemList = listOf<SportSmallItem>()
    init {
        load()
    }

    fun search(input: String?) {
        val searchList = if (input == null || input.isEmpty()) {
            println("input == null || input.isEmpty()")
            itemList
        } else {
            println("!input == null && !input.isEmpty()")
            itemList.filter { item ->
                searchItem(item, input.trim())
            }
        }
        items.value = searchList
    }

    private fun searchItem(item: SportSmallItem, searchText: String): Boolean {
        return item.cata.contains(searchText, ignoreCase = true)
    }

    private fun load(){
        val list = mutableListOf<SportSmallItem>()

        list.add(SportSmallItem("1","1", "槓鈴肩推"))
        list.add(SportSmallItem("1","2","啞鈴肩推"))
        list.add(SportSmallItem("1","3","啞鈴側平舉"))
        list.add(SportSmallItem("1","4","啞鈴前平舉"))
        list.add(SportSmallItem("1","5","站姿肩推"))
        list.add(SportSmallItem("2","1","啞鈴握推"))
        list.add(SportSmallItem("2","2","槓鈴握推"))
        list.add(SportSmallItem("2","3","蝴蝶機夾胸"))
        list.add(SportSmallItem("2","4","繩索下斜夾胸"))
        list.add(SportSmallItem("2","5","槓鈴斜上推"))

        this.itemList = list
        this.items.value = this.itemList
    }
}