package com.example.geniusgym.business.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.R
import com.example.geniusgym.business.model.Member
import com.example.geniusgym.business.viewModel.BuMemberViewModel
import com.example.geniusgym.databinding.FragmentBuMemberDataItemBinding
import com.example.geniusgym.sharedata.MeShareData.javaWebUrl

/**
 * 會員列表所需的Adapter
 */
class BuMemberDataAdapter(private var bumembers: List<Member>):
    RecyclerView.Adapter<BuMemberDataAdapter.BuMemberDataViewHolder>(){

    val url =  javaWebUrl + "buMember"

    /**
     * 更新會員列表內容
     * @param bumembers 新的會員列表
     */
    fun updateBuMember(bumembers: List<Member>) {
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
        with(holder) {
            with(itemViewBinding) {
                // 將欲顯示的member物件指派給LiveData，就會自動更新layout檔案的view顯示
                viewModel?.member?.value = bumember

                if (itemViewBinding.viewModel?.member?.value!!.m_sus == false) {
                    BuMemList.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.gray))
                }
                val bundle = Bundle()
                bundle.putSerializable("bumember", bumember)
                itemView.setOnClickListener {
                    //點擊list要跳到資料顯示頁面
                    Navigation.findNavController(it)
                        .navigate(R.id.buMemberDataDetailFragment, bundle)
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return bumembers.size
    }


}