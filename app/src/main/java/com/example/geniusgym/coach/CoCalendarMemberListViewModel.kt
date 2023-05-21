package com.example.geniusgym.coach

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.ClassItem


class CoCalendarMemberListViewModel : ViewModel() {
    val item : MutableLiveData<ClassItem> by lazy { MutableLiveData<ClassItem>() }
}
