package com.example.geniusgym.member

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.geniusgym.databinding.PopupwindowMeBranchBinding
import com.example.geniusgym.databinding.RecycleCellMeBranchBinding

class MeBranchAdapter(val stores: List<Store>) : RecyclerView.Adapter<MeBranchAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeBranchAdapter.MyViewHolder {
        val binding = RecycleCellMeBranchBinding.inflate(LayoutInflater.from(parent.context))
        val binding_popup = PopupwindowMeBranchBinding.inflate(LayoutInflater.from(parent.context))
        val popup_window = init_popupwindow(binding_popup)

        return MyViewHolder(binding, popup_window)
    }

    override fun getItemCount(): Int {
        return stores.size
    }

    private fun init_popupwindow(binding_popup: PopupwindowMeBranchBinding) : PopupWindow{

        val popup_window = PopupWindow(binding_popup.root)
        with(binding_popup){
            btCoach.setOnClickListener {

            }
            btDirect.setOnClickListener {

            }
            btStore.setOnClickListener {

            }
        }
        popup_window.width = ViewGroup.LayoutParams.WRAP_CONTENT
        popup_window.height = ViewGroup.LayoutParams.WRAP_CONTENT

        return popup_window
    }

    override fun onBindViewHolder(holder: MeBranchAdapter.MyViewHolder, position: Int) {
        holder.binding.tvBranchTitle.text = stores[position].bh_name.toString()
        holder.binding.tvPhonenumber.text = stores[position].bh_cell.toString()
        holder.binding.tvAddress.text = stores[position].bh_address.toString()
        holder.binding.btImgBranch.setOnClickListener {
            holder.popupwindow.showAsDropDown(it, 0, 0)

        }
//        TODO 時間格式要等可以串接了再調整，因此缺營業時間
    }

    class MyViewHolder(val binding: RecycleCellMeBranchBinding, val popupwindow: PopupWindow) : ViewHolder(binding.root)

}