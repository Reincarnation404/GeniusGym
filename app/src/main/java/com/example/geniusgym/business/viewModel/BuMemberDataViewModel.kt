package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geniusgym.R
import com.example.geniusgym.business.model.testBuMember

/**
 * 會員列表資料處理
 */
class BuMemberDataViewModel : ViewModel() {
    // 原始會員列表
    private var BuMemberList = mutableListOf<testBuMember>()
    // 受監控的LiveData，一旦指派新值就會更新會員列表畫面
    val members: MutableLiveData<List<testBuMember>> by lazy { MutableLiveData<List<testBuMember>>() }

    init {
        loadBuMember()
    }

    /**
     * 如果搜尋條件為空字串，就顯示原始會員列表；否則就顯示搜尋後結果
     * @param newText 欲搜尋的條件字串
     */
    fun search(newText: String?) {
        if (newText == null || newText.isEmpty()) {
            members.value = BuMemberList
        } else {
            val searchBumemberList = mutableListOf<testBuMember>()
            BuMemberList.forEach { bumember ->
                if (bumember.m_name!!.contains(newText, true)) {
                    searchBumemberList.add(bumember)
                }
            }
            members.value = searchBumemberList
        }
    }

    /** 模擬取得遠端資料 */
    private fun loadBuMember() {
        val BuMemberList = mutableListOf<testBuMember>()
        BuMemberList.add(testBuMember("m01","a123","Tiv水水","女",null,"H212345678","桃園內壢","2023/5/31 14:30","2027/6/1 00:00","2023/5/31 14:30","b99","123@gmail.com",R.drawable.seaotter2,true))
        BuMemberList.add(testBuMember("m02","b123","Tiv美美","女","0987654321","H287654321","桃園桃園","2023/5/31 15:30","2027/6/1 00:00","2023/5/31 15:30","b99","456@gmail.com",R.drawable.seaotter2,true))
        BuMemberList.add(testBuMember("m03","c123","Tiv漂漂","女","0910293847","H218273645","桃園中壢","2023/5/31 16:30","2027/6/1 00:00","2023/5/31 16:30","b99","789@gmail.com",R.drawable.seaotter2,true))

        this.BuMemberList = BuMemberList
        this.members.value = this.BuMemberList
    }
}