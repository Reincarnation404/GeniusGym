package com.example.geniusgym.member

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.geniusgym.coach.calendarMemberList.model.ClassItem
import com.example.geniusgym.member.model.MetrainBean
import com.example.geniusgym.databinding.FragmentMePersonalTrainBinding
import java.io.Serializable
import java.time.LocalDate

class MePersonalTrainViewModel : ViewModel() {
    // 創建一個 MutableLiveData，用於保存課程名稱
    val classname: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    // 創建一個 MutableLiveData，用於保存課程時間
    val classtime: MutableLiveData<LocalDate> by lazy { MutableLiveData<LocalDate>() }
    // 創建一個 List，用於保存 MeTrainBean 對象
    private var metrainlist = listOf<MetrainBean>()
    // 創建一個 MutableLiveData，用於保存 metrainlist 的數據
    val metrainitem: MutableLiveData<List<MetrainBean>> by lazy { MutableLiveData<List<MetrainBean>>() }

    // 初始化塊，在創建 ViewModel 的同時執行
    init{
        // 呼叫 loadItems 方法，用於初始化 metrainlist 數據
        loadItems()
    }

    // 搜尋方法，根據輸入的內容搜索課程
    fun search(input: String?) {
        // 如果輸入為空或者為空字符串，則返回所有的 metrainlist
        val searchList = if (input == null || input.isEmpty()) {
            metrainlist
        } else {
            // 使用 filter 方法篩選出符合條件的課程
            metrainlist.filter { item ->
                searchItem(item, input.trim())
            }
        }
        // 將搜索結果設置給 metrainitem 的 value
        metrainitem.value = searchList

    }

    //用於判斷課程是否符合搜索條件
    private fun searchItem(item: MetrainBean, searchText: String): Boolean {
        // 使用 contains 方法檢查 mtdate 是否包含搜索條件
        return item.mtdate.contains(searchText, ignoreCase = false)

    }
    private fun loadItems(){

        val metrainlist = mutableListOf<MetrainBean>()
        metrainlist.add(
            MetrainBean(
                mtid="111",
                mtstarttime = "12:00",
                mtendtime="14:00",
                mtdate="2023-06-12",
                myclassname="螺璇有氧"))

        metrainlist.add(
            MetrainBean(
                mtid="112",
                mtstarttime = "15:00",
                mtendtime="16:00",
                mtdate="2023-06-12",
                myclassname="突刺有氧"))

        metrainlist.add(
            MetrainBean(
                mtid="113",
                mtstarttime ="15:00",
                mtendtime="16:00",
                mtdate="2023-06-13",
                myclassname="倒立有氧"))

        metrainlist.add(
            MetrainBean(
                mtid="114",
                mtstarttime ="13:00",
                mtendtime="14:00",
                mtdate="2023-06-14",
                myclassname="螺璇有氧"))

        metrainlist.add(
            MetrainBean(
                mtid="115",
                mtstarttime ="16:00",
                mtendtime="17:00",
                mtdate="2023-06-14",
                myclassname="螺璇有氧"))

        metrainlist.add(
            MetrainBean(
                mtid="116",
                mtstarttime ="19:00",
                mtendtime="20:00",
                mtdate="2023-06-14",
                myclassname="螺璇有氧"))

        metrainlist.add(
            MetrainBean(
                mtid="117",
                mtstarttime ="10:00",
                mtendtime="11:00",
                mtdate="2023-06-15",
                myclassname="一對一課程"))

        //將外部傳入的 metrainlist（在方法參數中）賦值給了 ViewModel 內部的 metrainlist 變數。
        //這麼做是為了在方法內部可以使用 ViewModel 內的 metrainlist。
        this.metrainlist = metrainlist

        //將 ViewModel 內部的 metrainlist 賦值給 metrainitem 的 value 屬性。
        // 這麼做是為了在 ViewModel 的 metrainitem 能夠反映出 metrainlist 的數據。
        // 當 metrainlist 更新時，metrainitem 的觀察者也能夠收到更新的通知。
        this.metrainitem.value = this.metrainlist
    }

}