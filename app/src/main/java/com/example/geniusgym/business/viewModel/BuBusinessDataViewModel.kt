package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.R
import com.example.geniusgym.business.model.testBuBusiness
import com.example.geniusgym.business.model.testBuMember

/**
 * 員工列表資料處理
 */
class BuBusinessDataViewModel : ViewModel() {
    // 原始員工列表
    private var BuBusinessList = mutableListOf<testBuBusiness>()
    // 受監控的LiveData，一旦指派新值就會更新員工列表畫面
    val bubuzz: MutableLiveData<List<testBuBusiness>> by lazy { MutableLiveData<List<testBuBusiness>>() }

    init {
        loadBuBusiness()
    }

    /**
     * 如果搜尋條件為空字串，就顯示原始員工列表；否則就顯示搜尋後結果
     * @param newText 欲搜尋的條件字串
     */
    fun search(newText: String?) {
        if (newText == null || newText.isEmpty()) {
            bubuzz.value = BuBusinessList
        } else {
            val searchBubuzList = mutableListOf<testBuBusiness>()
            BuBusinessList.forEach { bubuz ->
                if (bubuz.b_name.contains(newText, true)) {
                    searchBubuzList.add(bubuz)
                }
            }
            bubuzz.value = searchBubuzList
        }
    }

    /** 模擬取得遠端資料 */
    private fun loadBuBusiness() {
        val BuBusinessList = mutableListOf<testBuBusiness>()
        BuBusinessList.add(testBuBusiness(R.drawable.seaotter2,"Tiv水水"))
        BuBusinessList.add(testBuBusiness(R.drawable.seaotter2,"Tiv美美"))
        BuBusinessList.add(testBuBusiness(R.drawable.seaotter2,"Tiv漂漂"))

        this.BuBusinessList = BuBusinessList
        this.bubuzz.value = this.BuBusinessList
    }


}