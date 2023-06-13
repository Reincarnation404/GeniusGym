package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BuClassDataAddViewModel : ViewModel() {
    val startTime: MutableLiveData<String> by lazy { MutableLiveData<String>() }

}