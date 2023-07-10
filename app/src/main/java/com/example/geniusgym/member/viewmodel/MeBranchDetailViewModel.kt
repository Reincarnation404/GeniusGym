package com.example.geniusgym.member.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.StoreBean
import com.example.geniusgym.sharedata.MeShareData
import com.example.geniusgym.util.IOImpl
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.geniusgym.business.core.service.requestTask

class MeBranchDetailViewModel : ViewModel() {
    var storeBeans : List<StoreBean> = listOf()

    fun loadDataFromIO(context : Context){
        val type = object : TypeToken<List<StoreBean>>() {}.type
        val jsonArray = IOImpl.Internal(context).loadArrayFile("branch", IOImpl.Mode.MODE_MEMORY, true)
        val array = Gson().fromJson<List<StoreBean>>(jsonArray, type)
        array?.let {
            storeBeans = array
        }

    }

    fun getDataFromInternet(context: Context){
        val type = object : TypeToken<List<StoreBean>>() {}.type
        val list = requestTask<List<StoreBean>>(MeShareData.javaWebUrl + "member/branch", method = "GET", respBodyType = type)
        list?.let {
            storeBeans = it
            val jsonArray = Gson().toJsonTree(it, type).asJsonArray
            IOImpl.Internal(context).saveFile(jsonArray, "branch", IOImpl.Mode.MODE_MEMORY, true)
        }

    }
}