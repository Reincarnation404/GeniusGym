package com.example.geniusgym.member.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.geniusgym.R
import com.example.geniusgym.databinding.PopupwindowMeBranchBinding
import com.example.geniusgym.databinding.RecycleCellMeBranchBinding
import com.example.geniusgym.member.model.StoreBean

class MeBranchAdapter(val storeBeans: List<StoreBean>) : RecyclerView.Adapter<MeBranchAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecycleCellMeBranchBinding.inflate(LayoutInflater.from(parent.context))

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return storeBeans.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvBranchTitle.text = storeBeans[position].bh_name.toString()
        holder.binding.tvPhonenumber.text = storeBeans[position].bh_cell.toString()
        holder.binding.tvAddress.text = storeBeans[position].bh_address.toString()
        holder.binding.btImgBranch.setOnClickListener {  btview ->
            val binding_popup = PopupwindowMeBranchBinding.inflate(LayoutInflater.from(btview.context))
            val popup_window = PopupWindow(binding_popup.root)
            popup_window.isOutsideTouchable = true
            popup_window.isFocusable = true

            with(binding_popup){
                btMeCoach.setOnClickListener {
                    btview.findNavController().navigate(R.id.action_meBranchDetailFragment_to_meCoachInfoFragment)
                    popup_window.dismiss()
                }


                btMeDirect.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putString("branchlocation", storeBeans[position].bh_address)
                    btview.findNavController().navigate(R.id.action_meBranchDetailFragment_to_meMapDirectFragment, bundle)
                    popup_window.dismiss()
                }
                btMeShop.setOnClickListener {
                    btview.findNavController().navigate(R.id.action_meBranchDetailFragment_to_meShoppingFragment)
                    popup_window.dismiss()
                }
            }
            popup_window.width = ViewGroup.LayoutParams.WRAP_CONTENT
            popup_window.height = ViewGroup.LayoutParams.WRAP_CONTENT
            popup_window.showAsDropDown(btview, 0, 0)

        }
//        TODO 時間格式要等可以串接了再調整，因此缺營業時間
    }

    class MyViewHolder(val binding: RecycleCellMeBranchBinding) : ViewHolder(binding.root)

}