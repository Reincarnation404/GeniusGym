package com.example.geniusgym.business.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.business.model.testBuMember
import com.example.geniusgym.business.viewModel.BuMemberViewModel
import com.example.geniusgym.databinding.FragmentBuMemberDataItemBinding

/**
 * 會員列表所需的Adapter
 */
class BuMemberDataAdapter(private var bumembers: List<testBuMember>):
    RecyclerView.Adapter<BuMemberDataAdapter.BuMemberDataViewHolder>(){


    /**
     * 更新會員列表內容
     * @param bumembers 新的會員列表
     */
    fun updateBuMember(bumembers: List<testBuMember>) {
        this.bumembers = bumembers
        notifyDataSetChanged()
    }

    class BuMemberDataViewHolder(val itemViewBinding: FragmentBuMemberDataItemBinding):
        RecyclerView.ViewHolder(itemViewBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuMemberDataViewHolder {
        val itemViewBinding = FragmentBuMemberDataItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        itemViewBinding.viewModel = BuMemberViewModel()
        // 設定lifecycleOwner方能監控LiveData資料變化，layout檔案的view才會更新顯示
        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return BuMemberDataViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(
        holder: BuMemberDataViewHolder,
        position: Int
    ) {
        val bumember = bumembers[position]
        with(holder){
            // 將欲顯示的member物件指派給LiveData，就會自動更新layout檔案的view顯示
            itemViewBinding.viewModel?.member?.value = bumember
            val bundle = Bundle()
            bundle.putSerializable("bumember", bumember)
            itemView.setOnClickListener {
                // 點擊list要跳到資料顯示頁面
                //Navigation.findNavController(it) .navigate(R.id.action_friendsFragment_to_friendDetailFragment, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return bumembers.size
    }


}