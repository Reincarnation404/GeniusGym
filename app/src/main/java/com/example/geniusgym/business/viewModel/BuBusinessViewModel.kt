package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.business.model.testBuBusiness
import com.example.geniusgym.business.model.testBuMember

class BuBusinessViewModel: ViewModel() {
    val buz: MutableLiveData<testBuBusiness> by lazy { MutableLiveData<testBuBusiness>() }
}