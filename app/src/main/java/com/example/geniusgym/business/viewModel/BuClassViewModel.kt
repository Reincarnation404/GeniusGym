package com.example.geniusgym.business.viewModel

import android.app.AlertDialog
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.business.model.Business
import com.example.geniusgym.business.model.Class_Info
import com.example.geniusgym.business.model.testClass_Info
import com.google.gson.JsonObject
import tw.idv.william.androidwebserver.core.service.requestTask
import java.text.SimpleDateFormat
import java.util.*

class BuClassViewModel : ViewModel() {
    val classs: MutableLiveData<Class_Info> by lazy { MutableLiveData<Class_Info>() }
    val url = "http://10.0.2.2:8080/geninusgym_bg/buClass"

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

    fun Available(view: View){
        if (classs?.value!!.ci_avail == true) {
            AlertDialog.Builder(view.context)
                .setMessage("確定將此課程停止報名?")
                .setPositiveButton("是") { _, _ ->
                    classs?.value.run {
                        requestTask<JsonObject>(url, "DELETE", classs.value)
                        println(classs?.value)
                    }
                }
                .setCancelable(true)
                .show()
        }else{
            AlertDialog.Builder(view.context)
                .setMessage("確定將此課程開放報名?")
                .setPositiveButton("是") { _, _ ->
                    classs?.value.run {
                        requestTask<JsonObject>(url, "DELETE", classs?.value)
                        println(classs?.value)
                    }
                }
                .setCancelable(true)
                .show()}
        true
    }

}