package com.example.geniusgym.member.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.MeBodyBean

class MeBodyViewModel : ViewModel() {
    // 創建一個 MutableLiveData，用於保存文本數據
    val text :MutableLiveData<String> by lazy { MutableLiveData<String>() }
    // 創建一個 MutableLiveData，用於保存 MeBodyBean 數據
    val bodydetail : MutableLiveData<MeBodyBean> by lazy { MutableLiveData<MeBodyBean>(
        MeBodyBean()
    )}

    // 初始化塊，在創建 ViewModel 的同時執行
init{
    // 呼叫 showmebody 方法，用於初始化 bodydetail 數據
    showmebody()
}
    // 用於初始化 bodydetail 數據
    private fun showmebody() {
        // 創建一個假的 MeBodyBean 對象
        val fakeBodyDetail = MeBodyBean(
            bdhight = "180cm",
            bdkg = "70kg",
            bdfat = "23%",
        )

        // 將創建的假數據設置給 bodydetail 的 value
        bodydetail.value = fakeBodyDetail
    }
}



