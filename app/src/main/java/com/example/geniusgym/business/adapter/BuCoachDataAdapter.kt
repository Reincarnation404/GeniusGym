package com.example.geniusgym.business.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.business.model.BuCoach
import com.example.geniusgym.business.model.testBuCoach
import com.example.geniusgym.business.model.testBuMember
import com.example.geniusgym.business.viewModel.BuCoachViewModel
import com.example.geniusgym.business.viewModel.BuMemberViewModel
import com.example.geniusgym.databinding.FragmentBuCoachDataItemBinding
import com.example.geniusgym.databinding.FragmentBuMemberDataItemBinding

/**
 * 教練列表所需的Adapter
 */
class BuCoachDataAdapter(private var bucoaches: List<testBuCoach>):
    RecyclerView.Adapter<BuCoachDataAdapter.BuCoachDataViewHolder>() {
    /**
     * 更新教練列表內容
     * @param bucoaches 新的教練列表
     */
    fun updateBuCoaches(bucoaches: List<testBuCoach>) {
        this.bucoaches = bucoaches
        notifyDataSetChanged()
    }

    class BuCoachDataViewHolder(val itemViewBinding: FragmentBuCoachDataItemBinding):
        RecyclerView.ViewHolder(itemViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuCoachDataAdapter.BuCoachDataViewHolder {
        val itemViewBinding = FragmentBuCoachDataItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        itemViewBinding.viewModel = BuCoachViewModel()
        // 設定lifecycleOwner方能監控LiveData資料變化，layout檔案的view才會更新顯示
        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return BuCoachDataAdapter.BuCoachDataViewHolder(itemViewBinding)
    }

    override fun getItemCount(): Int {
        return bucoaches.size
    }

    override fun onBindViewHolder(holder: BuCoachDataViewHolder, position: Int) {
        val bucoach = bucoaches[position]
        with(holder){
            // 將欲顯示的member物件指派給LiveData，就會自動更新layout檔案的view顯示
            itemViewBinding.viewModel?.coach?.value = bucoach
            val bundle = Bundle()
            bundle.putSerializable("bucoach", bucoach)
            itemView.setOnClickListener {
                // 點擊list要跳到資料顯示頁面
                //Navigation.findNavController(it) .navigate(R.id.action_friendsFragment_to_friendDetailFragment, bundle)
            }
        }
    }


}