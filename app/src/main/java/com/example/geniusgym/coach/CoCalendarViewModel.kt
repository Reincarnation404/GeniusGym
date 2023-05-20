package com.example.geniusgym.coach

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoCalendarViewModel : ViewModel() {
    val textDate: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}