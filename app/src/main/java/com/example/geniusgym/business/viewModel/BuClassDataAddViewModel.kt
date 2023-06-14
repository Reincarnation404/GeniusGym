package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.business.model.Class_Info
import java.text.SimpleDateFormat
import java.util.*

class BuClassDataAddViewModel : ViewModel() {
    val classs: MutableLiveData<Class_Info> by lazy { MutableLiveData<Class_Info>(Class_Info()) }

    fun startTimeToString():String? {
      val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
      return classs.value?.ci_start_time?.let { format.format(it) }
    }
    fun endTimeToString():String? {
      val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
      return classs.value?.ci_ed_time?.let { format.format(it) }
    }
    fun regiTimeToString():String? {
      val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
      return classs.value?.ci_regi_time?.let { format.format(it) }
    }
    fun regiEdTimeToString():String? {
      val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
      return classs.value?.ci_regi_ed_time?.let { format.format(it) }
    }

}