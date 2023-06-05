package com.example.geniusgym.coach.calendarMemberList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.ClassItem
import com.example.geniusgym.coach.calendarMemberList.model.MemberItem


class CoCalendarMemberListViewModel : ViewModel() {
    private var itemList = listOf<MemberItem>()
    val items: MutableLiveData<List<MemberItem>> by lazy { MutableLiveData<List<MemberItem>>() }
    val item: MutableLiveData<ClassItem> by lazy { MutableLiveData<ClassItem>() }
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

    private fun searchItem(item: MemberItem, searchText: String): Boolean {
        return item.classId.contains(searchText, ignoreCase = false)
    }

    private fun loadItems() {
        val itemList = mutableListOf<MemberItem>()
        // memberID 不可以是 dfg
        itemList.add(
            MemberItem(
                classId = "1234",
                memberId = "0001",
                name = "美秀集團",
            )
        )
        itemList.add(
            MemberItem(
                classId = "1234",
                memberId = "0002",
                name = "原子邦妮",
            )
        )
        itemList.add(
            MemberItem(
                classId = "1234",
                memberId = "0003",
                name = "宋德鶴",
            )
        )
        itemList.add(
            MemberItem(
                classId = "1234",
                memberId = "0004",
                name = "胡凱兒",
            )
        )
        itemList.add(
            MemberItem(
                classId = "12311111",
                memberId = "0005",
                name = "康士坦的變化球",
            )
        )
        itemList.add(
            MemberItem(
                classId = "12311111",
                memberId = "0006",
                name = "FORMOZA",
            )
        )

        itemList.add(
            MemberItem(
                classId = "1231112",
                memberId = "0007",
                name = "芒果醬B",
            )
        )
        itemList.add(
            MemberItem(
                classId = "1231112",
                memberId = "0008",
                name = "Gummy B",
            )
        )
        itemList.add(
            MemberItem(
                classId = "12311111",
                memberId = "0009",
                name = "步行者",
            )
        )
        itemList.add(
            MemberItem(
                classId = "12311111",
                memberId = "0010",
                name = "老王樂隊",
            )
        )
        itemList.add(
            MemberItem(
                classId = "456",
                memberId = "0011",
                name = "草東沒有派對",
            )
        )
        itemList.add(
            MemberItem(
                classId = "456",
                memberId = "0012",
                name = "血肉果汁機",
            )
        )
        itemList.add(
            MemberItem(
                classId = "789",
                memberId = "0013",
                name = "甜約翰",
            )
        )
        itemList.add(
            MemberItem(
                classId = "789",
                memberId = "0014",
                name = "逃走鮑伯",
            )
        )
        itemList.add(
            MemberItem(
                classId = "101112",
                memberId = "0015",
                name = "胭脂虎",
            )
        )
        itemList.add(
            MemberItem(
                classId = "101112",
                memberId = "0016",
                name = "賀爾蒙少年",
            )
        )
        this.itemList = itemList
        this.items.value = this.itemList
    }
}
