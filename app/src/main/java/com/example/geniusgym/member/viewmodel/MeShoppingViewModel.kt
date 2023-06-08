package com.example.geniusgym.member.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.ClassInfo


class MeShoppingViewModel : ViewModel() {
    val shopitems : MutableList<ClassInfo> by lazy { mutableListOf() }
//    var shopitems : LiveData<List<ClassInfo>> by lazy { MutableLiveData() }

    val branchName : MutableLiveData<String> by lazy { MutableLiveData() }

//    fun data(){
//        shopitems.value = _shopitems.value
//    }
    fun update(){
        shopitems.add(ClassInfo())
    }
}