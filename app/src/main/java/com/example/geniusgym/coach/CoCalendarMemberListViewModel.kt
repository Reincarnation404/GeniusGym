package com.example.geniusgym.coach

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
        itemList.add(
            MemberItem(
                classId = "1234",
                memberId = "456",
                name = "美秀集團",
            )
        )
        itemList.add(
            MemberItem(
                classId = "1234",
                memberId = "789",
                name = "原子邦妮",
            )
        )
        itemList.add(
            MemberItem(
                classId = "1234",
                memberId = "101112",
                name = "宋德鶴",
            )
        )
        itemList.add(
            MemberItem(
                classId = "1234",
                memberId = "GGGGG",
                name = "胡凱兒",
            )
        )
        itemList.add(
            MemberItem(
                classId = "12311111",
                memberId = "RX5168",
                name = "康士坦的變化球",
            )
        )
        itemList.add(
            MemberItem(
                classId = "12311111",
                memberId = "dfgdfgdf",
                name = "FORMOZA",
            )
        )
        itemList.add(
            MemberItem(
                classId = "1231112",
                memberId = "dfg",
                name = "芒果醬",
            )
        )
        itemList.add(
            MemberItem(
                classId = "1231112",
                memberId = "dsdfsdfg",
                name = "Gummy B",
            )
        )
        itemList.add(
            MemberItem(
                classId = "12311111",
                memberId = "dsdfsd",
                name = "步行者",
            )
        )
        itemList.add(
            MemberItem(
                classId = "12311111",
                memberId = "dsdfd",
                name = "老王樂隊",
            )
        )
        itemList.add(
            MemberItem(
                classId = "456",
                memberId = "dsdsd",
                name = "草東沒有派對",
            )
        )
        itemList.add(
            MemberItem(
                classId = "456",
                memberId = "hohoh",
                name = "血肉果汁機",
            )
        )
        itemList.add(
            MemberItem(
                classId = "789",
                memberId = "hoho789h",
                name = "甜約翰",
            )
        )
        itemList.add(
            MemberItem(
                classId = "789",
                memberId = "hoho78h",
                name = "逃走鮑伯",
            )
        )
        itemList.add(
            MemberItem(
                classId = "101112",
                memberId = "hoho78h",
                name = "胭脂虎",
            )
        )
        itemList.add(
            MemberItem(
                classId = "101112",
                memberId = "hoo78h",
                name = "賀爾蒙少年",
            )
        )
        this.itemList = itemList
        this.items.value = this.itemList
    }
}
