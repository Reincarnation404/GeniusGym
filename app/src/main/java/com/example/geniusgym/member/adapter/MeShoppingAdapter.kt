package com.example.geniusgym.member.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.R
import com.example.geniusgym.databinding.RecycleCellMeShoppingBinding
import com.example.geniusgym.member.model.ClassInfo
import com.example.geniusgym.member.viewmodel.MeRecycShopViewModel
import com.example.geniusgym.util.OnRepeatClickListener

class MeShoppingAdapter(private val shopitems : List<ClassInfo>) :
    RecyclerView.Adapter<MeShoppingAdapter.MyShopingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyShopingViewHolder {
        val binding: RecycleCellMeShoppingBinding = RecycleCellMeShoppingBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        binding.viewModel= MeRecycShopViewModel()
        binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return MyShopingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return shopitems.size
    }

    override fun onBindViewHolder(holder: MyShopingViewHolder, position: Int) {
        val shopitem = shopitems[position]
//        with(holder){
//            binding.viewModel?.shopitem?.value = shopitem
//        }
        with(holder.binding.viewModel!!){
            coachName.value = shopitem.c_id
            startToEnd.value = shopitem.ci_start_time + "~" + shopitem.ci_ed_time
            point.value = shopitem.ci_cost.toString()
            lessondate.value = shopitem.ci_date.toString()
        }
        val bundle = Bundle()
        bundle.putSerializable("lesson", shopitem)
        holder.itemView.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_meShoppingFragment_to_MeShoppingDetailFragment, bundle)
        }

    }

    class MyShopingViewHolder(val binding: RecycleCellMeShoppingBinding) : RecyclerView.ViewHolder(binding.root)

}