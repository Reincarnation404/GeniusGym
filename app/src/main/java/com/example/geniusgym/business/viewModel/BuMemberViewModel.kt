package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.business.model.testBuMember

class BuMemberViewModel: ViewModel() {
    val member: MutableLiveData<testBuMember> by lazy { MutableLiveData<testBuMember>() }
}