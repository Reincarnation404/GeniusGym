package com.example.geniusgym.member.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.example.geniusgym.R
import com.example.geniusgym.databinding.MePointsRecordCardviewBinding
import com.example.geniusgym.databinding.PopupwindowMeBranchBinding
import com.example.geniusgym.databinding.RecycleCellMeBranchBinding
import com.example.geniusgym.member.MePointsViewModel
import com.example.geniusgym.member.model.MePointBean
import com.example.geniusgym.member.model.MetrainBean
import com.example.geniusgym.member.model.StoreBean

class MePointsShowViewModel : ViewModel(){
    // 延遲初始化一個 MutableLiveData，用於存儲 MePointBean 物件
    val havepoint : MutableLiveData<MePointBean> by lazy { MutableLiveData<MePointBean>() } }

class MePointsAdapter (private var items: MutableList<MePointBean>):
        RecyclerView.Adapter<MePointsAdapter.MePointsViewHolder>(){

        // 定義 RecyclerView 的 ViewHolder
        class MePointsViewHolder (val itemViewBinding: MePointsRecordCardviewBinding):
        RecyclerView.ViewHolder(itemViewBinding.root )

    // 當需要創建新的 ViewHolder 時調用
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MePointsViewHolder {
        // 創建 ViewHolder 使用的綁定實例
        val itemViewBinding = MePointsRecordCardviewBinding.inflate(LayoutInflater.from(parent.context)
        ,parent,false)
        // 將 ViewModel 賦值給綁定實例的 viewModel
        itemViewBinding.viewModel = MePointsShowViewModel()
        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        // 傳回創建的 ViewHolder
        return  MePointsViewHolder(itemViewBinding) }

    // 當需要綁定數據到 ViewHolder 時調用
    override fun onBindViewHolder(holder: MePointsViewHolder, position: Int) {
        val item = items[position]
        val bundle = Bundle()
        with(holder){
            // 將 MePointBean 物件設置到 ViewModel 的 MutableLiveData
            itemViewBinding.viewModel?.havepoint?.value = item
            // 將 MePointBean 物件添加到 Bundle 中
            bundle.putSerializable("MePointBean",item) }
    }

    // 返回項目的數量
    override fun getItemCount(): Int {
        return items.size }

    // 更新項目列表並刷新 UI
    fun updateItem(items:MutableList<MePointBean>){
        this.items = items
        notifyDataSetChanged() }

    // 定義資料類別 PointItem，包含日期和積分信息
        data class PointItem(val date: String, val points: String)
    }















