package com.example.geniusgym.member.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.Member_detail_Item
import java.io.Serializable


//設定成一個物件導向member detail class  ->  viewmodel (mutablelivedata)

class MeMemberDetailViewModel : ViewModel() {
   val memdetail : MutableLiveData<Member_detail_Item> by lazy { MutableLiveData<Member_detail_Item>(
       Member_detail_Item()
   ) }
    init {
        showmemdetail()
    }

    private fun showmemdetail() {
        val fakeMemDetail = Member_detail_Item(
                name ="Danny",
                phonenumber = "0962078408",
                memberID = "Danny1023",
                entryTime = "2023-06-02 18:00",
                membershipdate = "2023-03-02 ~ 2023-06-02"
            )

        memdetail.value = fakeMemDetail
    }

    }






