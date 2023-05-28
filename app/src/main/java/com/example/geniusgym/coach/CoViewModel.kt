package com.example.geniusgym.coach

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoViewModel : ViewModel() {
   val name: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}