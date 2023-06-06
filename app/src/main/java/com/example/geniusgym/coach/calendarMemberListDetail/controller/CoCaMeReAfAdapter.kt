package com.example.geniusgym.coach.calendarMemberListDetail.controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordItem
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberRecordAfterViewModel
import com.example.geniusgym.databinding.FragmentCoCalendarMemberRecordAfterCardviewBinding

class CoCaMeReAfAdapter(private var items: List<SportRecordItem>) :
    RecyclerView.Adapter<CoCaMeReAfAdapter.CoCaMeReAfViewHolder>() {
    class CoCaMeReAfViewHolder(val itemViewBinding: FragmentCoCalendarMemberRecordAfterCardviewBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoCaMeReAfViewHolder {
        val itemViewBinding = FragmentCoCalendarMemberRecordAfterCardviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        itemViewBinding.viewModel = CoCalenderMemberRecordAfterViewModel()
        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return CoCaMeReAfViewHolder(itemViewBinding)

    }

    override fun onBindViewHolder(holder: CoCaMeReAfViewHolder, position: Int) {
        val item = items[position]
        with(holder){
            itemViewBinding.viewModel?.recordItem?.value = item
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}