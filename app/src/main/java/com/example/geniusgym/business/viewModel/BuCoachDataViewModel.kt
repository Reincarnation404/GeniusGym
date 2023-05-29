package com.example.geniusgym.business.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.R
import com.example.geniusgym.business.model.testBuCoach
import com.example.geniusgym.business.model.testBuMember

/**
 * 教練列表資料處理
 */
class BuCoachDataViewModel : ViewModel() {
    // 原始教練列表
    private var BuCoachList = mutableListOf<testBuCoach>()
    // 受監控的LiveData，一旦指派新值就會更新教練列表畫面
    val coaches: MutableLiveData<List<testBuCoach>> by lazy { MutableLiveData<List<testBuCoach>>() }

    init {
        loadBuCoach()
    }

    /**
     * 如果搜尋條件為空字串，就顯示原始教練列表；否則就顯示搜尋後結果
     * @param newText 欲搜尋的條件字串
     */
    fun search(newText: String?) {
        if (newText == null || newText.isEmpty()) {
            coaches.value = BuCoachList
        } else {
            val searchBucoachList = mutableListOf<testBuCoach>()
            BuCoachList.forEach { bucoach ->
                if (bucoach.c_name.contains(newText, true)) {
                    searchBucoachList.add(bucoach)
                }
            }
            coaches.value = searchBucoachList
        }
    }

    /** 模擬取得遠端資料 */
    private fun loadBuCoach() {
        val BuCoachList = mutableListOf<testBuCoach>()
        BuCoachList.add(testBuCoach(R.drawable.seaotter2,"Tiv美美"))
        BuCoachList.add(testBuCoach(R.drawable.seaotter2,"Tiv漂漂"))
        BuCoachList.add(testBuCoach(R.drawable.seaotter2,"Tiv水水"))

        this.BuCoachList = BuCoachList
        this.coaches.value = this.BuCoachList
    }


}