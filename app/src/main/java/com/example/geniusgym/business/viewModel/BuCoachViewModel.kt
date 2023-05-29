package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.business.model.testBuCoach
import com.example.geniusgym.business.model.testBuMember

class BuCoachViewModel: ViewModel() {
    val coach: MutableLiveData<testBuCoach> by lazy { MutableLiveData<testBuCoach>() }
}