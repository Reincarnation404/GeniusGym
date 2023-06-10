package com.example.geniusgym.member.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberList.viewmodel.CoCalendarMemberListViewModel
import com.example.geniusgym.coach.calendarMemberList.model.ClassItem
import com.example.geniusgym.databinding.FragmentCoCalendarClassCardviewBinding
import com.example.geniusgym.databinding.FragmentMeTrainingCalendarBinding
import com.example.geniusgym.member.MeTrainingCalendarViewModel
import com.example.geniusgym.member.model.TrainingItem

class TrainingItemAdapter(private var workoutitems: List<TrainingItem>) :
    RecyclerView.Adapter<TrainingItemAdapter.TrainingItemViewHolder>() {

    class TrainingItemViewHolder(val workoutitemViewBinding: FragmentMeTrainingCalendarBinding) :
        RecyclerView.ViewHolder(workoutitemViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingItemViewHolder {

        val workoutitemViewBinding = FragmentMeTrainingCalendarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        workoutitemViewBinding.viewModel = MeTrainingCalendarViewModel()
        workoutitemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return TrainingItemViewHolder(workoutitemViewBinding)
    }

    override fun getItemCount(): Int {
        return workoutitems.size
    }

    override fun onBindViewHolder(holder: TrainingItemViewHolder, position: Int) {
        val item = workoutitems[position]
        val bundle = Bundle()
        with(holder) {
            workoutitemViewBinding.viewModel?.workoutItem
            bundle.putSerializable("Class", item)
            itemView.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(
                        R.id.action_meTrainingCalendarFragment_to_meTrainingAerobicFragment,
                        bundle
                    )
            }
        }
    }
    fun updateItem(items: List<TrainingItem>){
        this.workoutitems = items
        notifyDataSetChanged()
    }
}