package com.example.geniusgym.member.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.databinding.MepersonaltraincardviewBinding
import com.example.geniusgym.member.model.MetrainBean

// onCreateViewHolder 主要用於創建 ViewHolder，並進行初始化設置，
// 而 onBindViewHolder 則用於將數據綁定到已有的 ViewHolder 上，實現動態顯示資料

class MeTrainShowViewModel:ViewModel() {
    // 延遲初始化一個 MutableLiveData，用於存儲 MetrainBean 物件
    val project : MutableLiveData<MetrainBean> by lazy {MutableLiveData<MetrainBean>()}
}

class MeTrainShowAdapter (private var items: List<MetrainBean>):
    RecyclerView.Adapter<MeTrainShowAdapter.MeTrainShowViewHolder>() {

        // 定義 RecyclerView 的 ViewHolder
        class MeTrainShowViewHolder(val itemViewBinding: MepersonaltraincardviewBinding ):
        RecyclerView.ViewHolder( itemViewBinding.root)

    // 當需要創建新的 ViewHolder 時調用
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeTrainShowViewHolder {
        // 創建 ViewHolder 使用的綁定實例
        val itemViewBinding = MepersonaltraincardviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        // 將 ViewModel 賦值給綁定實例的 viewModel
        itemViewBinding.viewModel =MeTrainShowViewModel()
        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        // 傳回創建的 ViewHolder
        return MeTrainShowViewHolder(itemViewBinding)
    }

    // 當需要綁定數據到 ViewHolder 時調用
    override fun onBindViewHolder(holder: MeTrainShowViewHolder, position: Int) {
        val item = items[position]
        val bundle = Bundle()
        with(holder){
            // 將 MetrainBean 物件設置到 ViewModel 的 MutableLiveData
            itemViewBinding.viewModel?.project?.value = item
            // 將 MetrainBean 物件添加到 Bundle 中
            bundle.putSerializable("metrain", item)

        }
    }

    // 返回項目的數量
    override fun getItemCount(): Int {
        return items.size
    }

    // 更新項目列表並刷新 UI
        fun updateItem(items:List<MetrainBean>){
           this.items = items
            notifyDataSetChanged()
    }
    }

