package com.example.geniusgym.coach.calendarMemberListDetail.controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberList.model.ExerciseItem
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberStaticViewModel
import com.example.geniusgym.databinding.FragmentCoCalendarMemberStaticCardviewBinding

class StatisticAdapter(
    private var items: List<ExerciseItem>,
    private var requireActivity: FragmentActivity
) :
    RecyclerView.Adapter<StatisticAdapter.ExerciseViewHolder>() {

    class ExerciseViewHolder(val itemViewBinding: FragmentCoCalendarMemberStaticCardviewBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemViewBinding = FragmentCoCalendarMemberStaticCardviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        itemViewBinding.viewModel = CoCalenderMemberStaticViewModel()
        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return ExerciseViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val item = items[position]
        with(holder) {
            itemViewBinding.viewModel?.exerciseItem?.value = item
            itemView.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.coCalenderMemberStaticSmallFragment)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun updateItem(items: List<ExerciseItem>){
        this.items = items
        notifyDataSetChanged()
    }

}