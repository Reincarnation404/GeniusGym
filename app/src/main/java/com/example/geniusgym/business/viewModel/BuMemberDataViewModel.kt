package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.R
import com.example.geniusgym.business.model.BuMember
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
                if (bumember.m_name.contains(newText, true)) {
                    searchBumemberList.add(bumember)
                }
            }
            members.value = searchBumemberList
        }
    }

    /** 模擬取得遠端資料 */
    private fun loadBuMember() {
        val BuMemberList = mutableListOf<testBuMember>()
        BuMemberList.add(testBuMember(R.drawable.seaotter2,"Tiv水水"))
        BuMemberList.add(testBuMember(R.drawable.seaotter2,"Tiv美美"))
        BuMemberList.add(testBuMember(R.drawable.seaotter2,"Tiv漂漂"))

        this.BuMemberList = BuMemberList
        this.members.value = this.BuMemberList
    }
}