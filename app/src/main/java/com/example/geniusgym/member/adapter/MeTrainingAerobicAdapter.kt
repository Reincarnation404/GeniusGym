package com.example.geniusgym.member.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberListDetail.controller.CoCaMeReOxAdapter
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportSmallItem
import com.example.geniusgym.databinding.FragmentMeTrainingAerobicBinding
import com.example.geniusgym.databinding.FragmentMeTrainingAerobicMaincataCardviewBinding
import com.example.geniusgym.member.MeTrainingAerobicViewModel
import com.example.geniusgym.member.model.WorkoutSecondItem
import com.example.geniusgym.member.model.WorkoutSmallItem

class MeTrainingAerobicAdapter(private var items: List<WorkoutSmallItem>) :
    RecyclerView.Adapter<MeTrainingAerobicAdapter.AeroMainItemViewHolder>() {

    class AeroMainItemViewHolder(val itemViewBinding: FragmentMeTrainingAerobicMaincataCardviewBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AeroMainItemViewHolder {
        val itemViewBinding = FragmentMeTrainingAerobicMaincataCardviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        itemViewBinding.viewModel = MeTrainingAerobicViewModel()
        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return AeroMainItemViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: AeroMainItemViewHolder, position: Int) {
        val item = items[position]
        val bundle = Bundle()
        with(holder) {
            itemViewBinding.viewModel?.item?.value = item
            bundle.putSerializable("item", item)
            itemView.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    R.id.action_meTrainingFirstPageFragment2_to_meTrainingRecordFragment,
                    bundle
                )

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update(items: List<WorkoutSmallItem>) {
        this.items = items
        notifyDataSetChanged()
    }
}