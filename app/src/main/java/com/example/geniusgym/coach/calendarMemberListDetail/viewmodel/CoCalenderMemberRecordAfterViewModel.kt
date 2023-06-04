package com.example.geniusgym.coach.calendarMemberListDetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.MemberItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportSmallItem

class CoCalenderMemberRecordAfterViewModel : ViewModel() {
    val recordItems: MutableLiveData<MutableList<SportRecordItem>> by lazy { MutableLiveData<MutableList<SportRecordItem>>() }
    val recordItem: MutableLiveData<SportRecordItem> by lazy { MutableLiveData<SportRecordItem>() }
    val errorMessage: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val item: MutableLiveData<SportSmallItem> by lazy { MutableLiveData<SportSmallItem>() }
    val member: MutableLiveData<MemberItem> by lazy { MutableLiveData<MemberItem>() }
    val name: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val sportName: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val weight: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val freq: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    var sc_id: String = ""
    var m_id: String = ""
    val recordList = mutableListOf<SportRecordItem>()
    /*init {
        load()
    }

    private fun load() {
        recordItems.value = arrayListOf()
    }*/

    fun onClick() {

        if (!stringCheck(weight?.value) || !stringCheck(freq?.value)) {
            errorMessage.value = "請檢查重量或次數是否有正確輸入"
            return
        }
        errorMessage.value = ""
        val item = SportRecordItem(
            m_id = this.m_id,
            m_name = name?.value,
            sc_id = this.sc_id,
            sc_name = sportName?.value,
            sc_weight = weight?.value,
            sc_freq = freq?.value,
            c_id = "RRRRR"
        )
        recordList.add(item)
        recordItems.value = recordList
    }

    private fun stringCheck(string: String?): Boolean {
        // 如果輸出為 true ，代表字串通過檢查
        return if (string == null) {
            false
        } else {
            string.trim().isNotEmpty() &&
                    string.matches(Regex("[1-9]\\d*"))
        }
    }
}