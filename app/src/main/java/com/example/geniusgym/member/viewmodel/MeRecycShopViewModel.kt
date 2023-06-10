package com.example.geniusgym.member.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.ClassInfo

class MeRecycShopViewModel : ViewModel() {
    val shopitem : MutableLiveData<ClassInfo> by lazy { MutableLiveData<ClassInfo>() }
}