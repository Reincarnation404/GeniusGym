package com.example.geniusgym.member.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.geniusgym.databinding.FragmentMeBuyPointsBinding
import com.example.geniusgym.member.model.MeBuyPointBean



class MeBuyPointsShowViewModel : ViewModel(){
    val pointbuy  : MutableLiveData<MeBuyPointBean> by lazy { MutableLiveData<MeBuyPointBean>() } }

class MeBuyPointsAdapter(private var items : MutableList<MeBuyPointBean> ) :
    RecyclerView.Adapter<MeBuyPointsAdapter.MePointsShowViewHolder>(){

    class MePointsShowViewHolder (val itemViewBinding: FragmentMeBuyPointsBinding):
          RecyclerView.ViewHolder(itemViewBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeBuyPointsAdapter.MePointsShowViewHolder {
       val itemViewBinding = FragmentMeBuyPointsBinding.inflate(LayoutInflater.from(parent.context),parent,false )

        itemViewBinding.viewmodel = MeBuyPointsShowViewModel()
        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return MePointsShowViewHolder(itemViewBinding)}

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: MeBuyPointsAdapter.MePointsShowViewHolder, position: Int) {
        val item = items[position]
        val bundle = Bundle()
        with(holder){
            itemViewBinding.viewmodel?.pointbuy?.value = item
            bundle.putSerializable("MeBuyPointBean",item) }
        }


    fun updateItem(items: MutableList<MeBuyPointBean>){
        this.items = items
        notifyDataSetChanged() }
    }
































