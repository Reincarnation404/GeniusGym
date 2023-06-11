package com.example.geniusgym.member.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.member.model.ClassInfo
import com.example.geniusgym.member.model.SportBigCat
import com.example.geniusgym.member.model.SportCat


class MeShoppingViewModel : ViewModel() {

    private val _shopitems = mutableListOf<ClassInfo>()
    val shopitems : MutableLiveData<List<ClassInfo>> by lazy { MutableLiveData() }
    val branchName : MutableLiveData<String> by lazy { MutableLiveData() }
    init {
        update()

    }
    private fun update(){
        _shopitems.add(ClassInfo(1, "基礎肌力", "09:00", "12:00", "緯育分店",
                                    500, 1, "2023/06/11", "本課程希望大家能認真學習", 50,
                                    1, "Sam", "employee")
        )
        _shopitems.add(ClassInfo(2, "燃脂肌力", "09:00", "12:00", "緯育分店",
                                    500, 1, "2023/06/16", "本課程希望大家能認真學習", 50,
                                    1, "Andy", "employee")
        )
        _shopitems.add(ClassInfo(3, "基礎壺鈴", "18:00", "21:00", "緯育分店",
            500, 2, "2023/06/21", "本課程希望大家能認真學習", 50,
            1, "張小喵", "employee")
        )
        _shopitems.add(ClassInfo(4, "下肢肌力", "014:00", "15:00", "緯育分店",
            500, 4, "2023/06/30", "本課程希望大家能認真學習", 50,
            1, "博博教練", "employee")
        )
        _shopitems.add(ClassInfo(5, "徒手肌力", "09:00", "12:00", "緯育分店",
            500, 4, "2023/06/11", "本課程希望大家能認真學習", 50,
            1, "余阿汪", "employee")
        )

        shopitems.value = _shopitems
    }


    fun search(set: Set<Int>, searchText : String) {
        val setFiltered  = mutableSetOf<ClassInfo>()
        if (set.isEmpty()) {
//           doNothing
        } else {
            set.forEach {filterId ->
                _shopitems.forEach{
                    if (it.sc_id == filterId){
                        setFiltered.add(it)
                    }
                }
            }
            shopitems.value = setFiltered.toList()
        }
        if (searchText.isEmpty() || searchText.isBlank()){

        }else{
            _shopitems.forEach{
                if (it.ci_name.contains(searchText) || it.c_id.contains(searchText)){
                    setFiltered.add(it)
                }
            }
            shopitems.value = setFiltered.toList()
        }
    }

//    TEST DATA
    val sportbigcats : List<SportBigCat> = listOf(
        SportBigCat(1, "有氧", "有氧"),
        SportBigCat(2, "無氧", "肩"),
        SportBigCat(3, "無氧", "胸"),
//        SportBigCat(4, "缺氧", "背"),
//        SportBigCat(5, "沒氧", "腿")
    )

    val sportcats : List<List<SportCat>> = listOf(

        listOf(
            SportCat(1, 1, "飛輪"),
            SportCat(2, 1, "靜態"),
            SportCat(3, 1, "心肺訓練"),
            SportCat(4, 1, "跑步"),
        ),
        listOf(
            SportCat(5, 2, "槓鈴肩推"),
            SportCat(6, 2, "啞鈴肩推"),
            SportCat(7, 2, "啞鈴側平舉"),
            SportCat(8, 2, "啞鈴前平舉"),
            SportCat(9, 2, "站姿肩推")
        ),
        listOf(
            SportCat(10, 3, "啞鈴握推"),
            SportCat(11, 3, "槓鈴握推"),
            SportCat(12, 3, "蝴蝶機夾胸"),
            SportCat(13, 3, "繩索下斜夾胸"),
            SportCat(14,3, "槓鈴斜上推")
        )

    )
}