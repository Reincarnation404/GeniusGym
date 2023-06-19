package com.example.geniusgym.coach

import android.content.Context
import android.graphics.Bitmap
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geniusgym.coach.calendarMemberList.model.MemberItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.CoachItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportBigItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportSmallItem
import com.example.geniusgym.util.WebRequestSpencer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CoViewModel : ViewModel() {
    val name: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val member: MutableLiveData<MemberItem> by lazy { MutableLiveData<MemberItem>() }
    val sportSmallItems: MutableLiveData<List<SportSmallItem>> by lazy { MutableLiveData<List<SportSmallItem>>() }
    val sportBigItems: MutableLiveData<List<SportBigItem>> by lazy { MutableLiveData<List<SportBigItem>>() }
    val coach: MutableLiveData<CoachItem> by lazy { MutableLiveData<CoachItem>() }
    val homeQrcodeMap: MutableLiveData<Bitmap> by lazy { MutableLiveData<Bitmap>() }
    val homeTimerString: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    init {
        loadFake()
    }

    fun loadSportFromPreference(coActivity: CoActivity) {
        val gson = GsonBuilder().create()
        val smallItemType = object : TypeToken<List<SportSmallItem>?>() {}.type
        val bigItemType = object : TypeToken<List<SportBigItem>?>() {}.type
        val preferences = coActivity.getPreferences(Context.MODE_PRIVATE)
        val smallJson = preferences.getString("sportSmallItems", "")
        preferences.getString("sportBigItems", "")
        sportSmallItems?.value = gson.fromJson(smallJson, smallItemType)
        sportBigItems?.value = gson.fromJson(smallJson, bigItemType)
    }

    fun loadSportSmallItem(coActivity: CoActivity) {
        viewModelScope.launch {
            val deffered1 = async { sportSmallItemImport(coActivity) }
            sportSmallItems?.value = deffered1.await()
        }
    }

    fun loadSportBigItem(coActivity: CoActivity) {
        viewModelScope.launch {
            val deffered2 = async { sportBigItemImport(coActivity) }
            sportBigItems?.value = deffered2.await()
        }
    }

    private suspend fun sportSmallItemImport(coActivity: CoActivity): List<SportSmallItem> {
        val json = WebRequestSpencer().httpPost("GetSportCat", "start")
        return if (json == "ConnectError") {
            Toast.makeText(coActivity, "連線失敗", Toast.LENGTH_SHORT).show()
            listOf()

        } else if (json != "") {
            println("String $json")
            val type = object : TypeToken<List<SportSmallItem>?>() {}.type
            println("JSONPOSTSMALL: $this")
            Gson().fromJson(json, type)
        } else {
            listOf()
        }
    }

    private suspend fun sportBigItemImport(coActivity: CoActivity): List<SportBigItem> {
        val json = WebRequestSpencer().httpGet("GetSportCat")
        return if (json == "ConnectError") {
            Toast.makeText(coActivity, "連線失敗", Toast.LENGTH_SHORT)
            listOf()
        } else if (json != "") {
            val type = object : TypeToken<List<SportBigItem>?>() {}.type
            Gson().fromJson(json, type)
        } else {
            listOf()
        }
    }

    private fun loadFake() {
        coach?.value =
            CoachItem(
                c_name = "桃園 hawk",
                c_cell = "0912345678",
                c_id = "C87632",
                c_start_date = "2023/06/15"
            )
    }
}