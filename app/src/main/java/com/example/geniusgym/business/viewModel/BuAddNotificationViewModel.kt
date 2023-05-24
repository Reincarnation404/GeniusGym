package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BuAddNotificationViewModel : ViewModel() {
    val sender: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val title: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val text: MutableLiveData<String> by lazy { MutableLiveData<String>() }
//    val branches: MutableLiveData<List<String>>
//            by lazy { MutableLiveData<List<String>>(listOf("分店A", "分店B", "分店C", "分店D")) }
}