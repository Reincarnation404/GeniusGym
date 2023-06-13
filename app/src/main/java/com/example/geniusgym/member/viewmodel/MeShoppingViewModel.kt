package com.example.geniusgym.member.viewmodel

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ImageSpan
import android.view.Gravity
import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geniusgym.R
import com.example.geniusgym.databinding.DialogShopitemBinding
import com.example.geniusgym.member.adapter.MeShoppingAdapter
import com.example.geniusgym.member.adapter.MeShoppingSearchExpandableListViewAdapter
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
//           doNothing
        }else{
            _shopitems.forEach{
                if (it.ci_name!!.contains(searchText) || it.c_id!!.contains(searchText)){
                    setFiltered.add(it)
                }
            }
            shopitems.value = setFiltered.toList()
        }
    }

    @SuppressLint("ResourceType")
    fun createDiaglog(context : Context, meAdapter: MeShoppingAdapter) : Dialog {
        val dialog = Dialog(context)
        val bindingDialog : DialogShopitemBinding = DialogShopitemBinding.inflate(LayoutInflater.from(context))

        //        設定dialog
        val window = dialog.window
        window?.setGravity(Gravity.CENTER)
        window?.setContentView(bindingDialog.root)
        window?.setWindowAnimations(R.xml.dialog_style)
//        TODO:動畫執行失敗、設定dialog大小失敗
//        val lp = window?.attributes
//        lp?.width = WindowManager.LayoutParams.MATCH_PARENT
//        lp?.height = containerView.layoutParams.height



        //        設定提示文字附加圖片
        val imageHint = ImageSpan(context, R.drawable.baseline_search_24)
        val spannableString = SpannableString(context.getString(R.string.meSearchViewLessonName))
        spannableString.setSpan(imageHint, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        bindingDialog.edtMeShoppingSearch.hint = spannableString
        val adapter =
            MeShoppingSearchExpandableListViewAdapter(
                context,
                sportbigcats,
                sportcats
            )
        bindingDialog.elvMeShopping.setAdapter(adapter)
        bindingDialog.btnMeShoppingConfirm.setOnClickListener {
            val filterId = adapter.getAllKindId()
            search(filterId, bindingDialog.edtMeShoppingSearch.text.toString())
            shopitems.value?.let { it1 -> meAdapter.update(it1) }
            adapter.clearSet()
            dialog.dismiss()
        }

        bindingDialog.btnMeShoppingCancel.setOnClickListener {
            adapter.clearSet()
            dialog.dismiss()
        }
        return dialog
    }


    private fun update(){
        _shopitems.add(ClassInfo(1, "基礎肌力", "09:00", "12:00", "緯育分店",
                                    500, 1, "2023/06/11", "本課程希望大家能認真學習", 50,
                                    "Sam")
        )
        _shopitems.add(ClassInfo(2, "燃脂肌力", "09:00", "12:00", "緯育分店",
                                    500, 1, "2023/06/16", "本課程希望大家能認真學習", 50,
                                    "Andy")
        )
        _shopitems.add(ClassInfo(3, "基礎壺鈴", "18:00", "21:00", "緯育分店",
            500, 2, "2023/06/21", "本課程希望大家能認真學習", 50,
            "張小喵")
        )
        _shopitems.add(ClassInfo(4, "下肢肌力", "014:00", "15:00", "緯育分店",
            500, 4, "2023/06/30", "本課程希望大家能認真學習", 50,
            "博博教練")
        )
        _shopitems.add(ClassInfo(5, "徒手肌力", "09:00", "12:00", "緯育分店",
            500, 4, "2023/06/11", "本課程希望大家能認真學習", 50,
            "余阿汪")
        )

        shopitems.value = _shopitems
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