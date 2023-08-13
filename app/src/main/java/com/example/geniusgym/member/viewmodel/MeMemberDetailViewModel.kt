package com.example.geniusgym.member.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.coach.calendarMemberList.model.Member_detail_Item
import java.io.Serializable

//設定成一個物件導向member detail class  ->  viewmodel (mutablelivedata)

class MeMemberDetailViewModel : ViewModel() {
    // 創建一個 MutableLiveData，用於保存文本數據
    val text: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    // 創建一個 MutableLiveData，用於保存 Member_detail_Item 數據
    //延遲初始化的 MutableLiveData 屬性，該屬性的初始值為一個空的 Member_detail_Item 對象。
    // 這個屬性可以在需要時用於保存 Member_detail_Item 數據，並且只有在第一次被訪問時才會實際初始化。
    val memdetail : MutableLiveData<Member_detail_Item> by lazy { MutableLiveData<Member_detail_Item>(
       Member_detail_Item()
   ) }

    // 初始化塊，在創建 ViewModel 的同時執行
    init {
        // 呼叫 showmemdetail 方法，用於初始化 memdetail 數據
        showmemdetail()
    }

    private fun showmemdetail() {
        // 創建一個假的 Member_detail_Item 對象，用於初始化數據
        val fakeMemDetail = Member_detail_Item(
                name ="Danny",
                phonenumber = "0962078408",
                memberID = "M81032",
                entryTime = "2023-06-13 18:00",
                membershipdate = "2023-03-02 ~ 2024-03-02"
            )
        // 將創建的假數據設置給 memdetail 的 value
        memdetail.value = fakeMemDetail
    }

    }






