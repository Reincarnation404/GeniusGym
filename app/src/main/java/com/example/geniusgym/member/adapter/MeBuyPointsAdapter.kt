package com.example.geniusgym.member.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.geniusgym.R
import com.example.geniusgym.business.BuActivity
import com.example.geniusgym.databinding.FragmentMeBuyPointsBinding
import com.example.geniusgym.member.MeCreditCardActivity
import com.example.geniusgym.member.model.MeBuyPointBean


class MeBuyPointsShowViewModel : ViewModel(){
    // 延遲初始化一個 MutableLiveData，用於存儲 MeBuyPointBean 物件
    val pointbuy  : MutableLiveData<MeBuyPointBean> by lazy { MutableLiveData<MeBuyPointBean>() }

    // 這個方法用於處理前往信用卡頁面的操作
    fun goToCreditCard(view : View, item : MeBuyPointBean){
        // 創建一個 Intent，指定目標為 MeCreditCardActivity 類
        val intent = Intent(view.context, MeCreditCardActivity::class.java)
        // 創建一個 Bundle 並將 item 傳遞給它
        val bundle = Bundle()
        bundle.putSerializable("saveItem", item)
        // 將 Bundle 放入 Intent 中
        intent.putExtra("savebundle", bundle)
        // 啟動目標 Activity
        view.context.startActivity(intent)
    }
}

class MeBuyPointsAdapter(private var items : MutableList<MeBuyPointBean> ) :
    RecyclerView.Adapter<MeBuyPointsAdapter.MePointsShowViewHolder>(){

    // 定義 RecyclerView 的 ViewHolder
    class MePointsShowViewHolder (val itemViewBinding: FragmentMeBuyPointsBinding):
          RecyclerView.ViewHolder(itemViewBinding.root)

    // 當需要創建新的 ViewHolder 時調用
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeBuyPointsAdapter.MePointsShowViewHolder {
        // 創建 ViewHolder 使用的綁定實例
       val itemViewBinding = FragmentMeBuyPointsBinding.inflate(LayoutInflater.from(parent.context),parent,false )
        // 將 ViewModel 賦值給綁定實例的 viewmodel
        itemViewBinding.viewmodel = MeBuyPointsShowViewModel()
        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        // 傳回創建的 ViewHolder
        return MePointsShowViewHolder(itemViewBinding)}

    // 返回項目的數量
    override fun getItemCount(): Int {
        return items.size
    }


    // 當需要綁定數據到 ViewHolder 時調用
    override fun onBindViewHolder(holder: MeBuyPointsAdapter.MePointsShowViewHolder, position: Int) {
        val item = items[position]

        with(holder.itemViewBinding){
            // 將 MeBuyPointBean 物件設置到 ViewModel 的 MutableLiveData
            viewmodel?.pointbuy?.value = item
            // 當按鈕 btBuyPoint 被點擊時，執行以下操作
            btBuyPoint.setOnClickListener {
                Log.d("creditCard", item.toString())
                // 呼叫 ViewModel 的 goToCreditCard 方法，前往信用卡頁面
                viewmodel?.goToCreditCard(it, item)

            }}

        }
    }
































