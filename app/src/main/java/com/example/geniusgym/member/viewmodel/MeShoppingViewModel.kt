package com.example.geniusgym.member.viewmodel

import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.ClassInfo

class MeShoppingViewModel : ViewModel() {
    private val _shopitems : MutableList<ClassInfo> by lazy { mutableListOf() }
    val shopitems : List<ClassInfo> = _shopitems
}