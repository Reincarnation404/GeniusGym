package com.example.geniusgym.member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.geniusgym.databinding.PopupwindowMeBranchBinding
import com.example.geniusgym.databinding.RecycleCellMeBranchBinding

class MeBranchAdapter(val storeBeans: List<StoreBean>) : RecyclerView.Adapter<MeBranchAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeBranchAdapter.MyViewHolder {
        val binding = RecycleCellMeBranchBinding.inflate(LayoutInflater.from(parent.context))

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return storeBeans.size
    }

    override fun onBindViewHolder(holder: MeBranchAdapter.MyViewHolder, position: Int) {
        holder.binding.tvBranchTitle.text = storeBeans[position].bh_name.toString()
        holder.binding.tvPhonenumber.text = storeBeans[position].bh_cell.toString()
        holder.binding.tvAddress.text = storeBeans[position].bh_address.toString()
        holder.binding.btImgBranch.setOnClickListener {
            val binding_popup = PopupwindowMeBranchBinding.inflate(LayoutInflater.from(it.context))
            val popup_window = PopupWindow(binding_popup.root)
//            val bundle = Bundle()
//            bundle.putInt("branch", storeBeans[position].bh_id)
            with(binding_popup){
                btCoach.setOnClickListener {
//                TODO: 頁面跳轉
                }
                btDirect.setOnClickListener {
                 val bundle = Bundle()
                    bundle.putString("branchlocation", storeBeans[position].bh_address)
                }
                btStore.setOnClickListener {
//                TODO: 頁面跳轉
                }
            }
            popup_window.width = ViewGroup.LayoutParams.WRAP_CONTENT
            popup_window.height = ViewGroup.LayoutParams.WRAP_CONTENT
            popup_window.showAsDropDown(it, 0, 0)

        }
//        TODO 時間格式要等可以串接了再調整，因此缺營業時間
    }

    class MyViewHolder(val binding: RecycleCellMeBranchBinding) : ViewHolder(binding.root)

}