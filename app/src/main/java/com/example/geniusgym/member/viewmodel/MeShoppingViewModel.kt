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
import com.example.geniusgym.sharedata.MeShareData
import com.example.geniusgym.util.IOImpl
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import tw.idv.william.androidwebserver.core.service.requestTask


class MeShoppingViewModel : ViewModel() {

    private val _shopitems = mutableListOf<ClassInfo>()
    val shopitems : MutableLiveData<List<ClassInfo>> by lazy { MutableLiveData() }
    val branchName : MutableLiveData<String> by lazy { MutableLiveData() }
    private var sportbigcats : List<SportBigCat> = listOf()
    private var sportcats : List<List<SportCat>> = listOf()
    init {
        update()

    }

    fun getClassInfoFromLocal(context: Context){
        val classType = object : TypeToken<List<ClassInfo>>(){}.type
        val jsonArray = IOImpl.Internal(context).loadArrayFile("ClassInfoList", IOImpl.Mode.MODE_MEMORY, true)
        val classInfoList = Gson().fromJson<List<ClassInfo>>(jsonArray, classType)
        shopitems.value = classInfoList
    }

    fun getClassInfoFromInternal(context: Context){
        val classType = object : TypeToken<List<ClassInfo>>(){}.type
        val classInfoList = requestTask<List<ClassInfo>>(MeShareData.javaWebUrl + "", "GET", respBodyType = classType)
        classInfoList?.let {
            shopitems.value = it
            val jsonArray = Gson().toJsonTree(it, classType).asJsonArray
            IOImpl.Internal(context).saveFile(jsonArray, "ClassInfoList", IOImpl.Mode.MODE_MEMORY, true)
        }

    }

    private fun update(){

        _shopitems.add(ClassInfo(1, "螺旋有氧", "14:00", "15:00", "A502",
                                    500, 8, "2023/04/15", "本課程希望大家能認真學習", 50,
                                    "桃園 hawk")
        )
        _shopitems.add(ClassInfo(2, "基礎肌力", "09:00", "12:00", "A503",
                                    500, 5, "2023/06/15", "本課程希望大家能認真學習", 50,
                                    "王曉明")
        )
        shopitems.value = _shopitems
    }

    fun getCategory(context: Context){

        val bcType = object : TypeToken<List<SportBigCat>>(){}.type
        val cType = object : TypeToken<List<SportCat>>(){}.type

        val result = IOImpl.Internal(context).loadArrayFile("BigCategory", IOImpl.Mode.MODE_MEMORY, true)
        val result2 = IOImpl.Internal(context).loadArrayFile("Category", IOImpl.Mode.MODE_MEMORY, true)

        if (result != null && result2 != null ){
            sportbigcats = Gson().fromJson(result, bcType)
            sportcats = toListArray(Gson().fromJson(result2, cType))
            return
        }

        val bcList = requestTask<List<SportBigCat>>(MeShareData.javaWebUrl + "GetSportCat", "GET", respBodyType = bcType)
        bcList?.let {
            sportbigcats = it
            val jsonArray = Gson().toJsonTree(it, bcType).asJsonArray
            IOImpl.Internal(context).saveFile(jsonArray, "BigCategory", IOImpl.Mode.MODE_MEMORY, true)
        }

        val cList = requestTask<List<SportCat>>(MeShareData.javaWebUrl + "sportcats", "GET", respBodyType = cType)
        cList?.let {
            sportcats = toListArray(cList)
            val jsonArray = Gson().toJsonTree(it, cType).asJsonArray
            IOImpl.Internal(context).saveFile(jsonArray, "Category", IOImpl.Mode.MODE_MEMORY, true)
        }

    }

    private fun toListArray( list : List<SportCat>) : List<List<SportCat>>{

        val reList : MutableList<MutableList<SportCat>> = mutableListOf()
        for (i in 0 .. 4){
            reList.add(mutableListOf())
        }
        for ( i in list.indices){
            val id = list[i].sb_id
            reList[id-1].add(list[i])
        }

        return reList
    }

    private fun search(set: Set<Int>, searchText : String) {
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
//        設定dialog頁面
        val window = dialog.window
        window?.setGravity(Gravity.CENTER)
        window?.setContentView(bindingDialog.root)
        window?.setWindowAnimations(R.style.dialog_style)
//        TODO:動畫執行失敗

//        設定EditText的提示文字
        bindingDialog.edtMeShoppingSearch.hint = setDialogSpannableString(context)

//        設定adapter
        val adapter = setDialogAdapter(context)
        bindingDialog.elvMeShopping.setAdapter(adapter)

        bindingDialog.btnMeShoppingConfirm.setOnClickListener {
//            取得篩選的運動類型、教練名稱、課程名稱
            val filterId = adapter.getAllKindId()
//            執行搜尋
            search(filterId, bindingDialog.edtMeShoppingSearch.text.toString())
//            將結果返回並更新MeShopping的RecycleView
            shopitems.value?.let { it1 -> meAdapter.update(it1) }
//            清除這次已點擊的類型
            adapter.clearSet()
            dialog.dismiss()
        }

        bindingDialog.btnMeShoppingCancel.setOnClickListener {
//            清除這次已點擊的類型
            adapter.clearSet()
            dialog.dismiss()
        }
        return dialog
    }

    private fun setDialogAdapter(context: Context) : MeShoppingSearchExpandableListViewAdapter{
        getCategory(context)
        val adapter =
            MeShoppingSearchExpandableListViewAdapter(
                context,
                sportbigcats,
                sportcats
            )
        return adapter
    }
    private fun setDialogSpannableString(context : Context) : SpannableString{
        //        設定提示文字附加圖片
        val imageHint = ImageSpan(context, R.drawable.baseline_search_24)
        val spannableString = SpannableString(context.getString(R.string.meSearchViewLessonName))
        spannableString.setSpan(imageHint, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        return spannableString
    }


}