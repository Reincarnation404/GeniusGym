package com.example.geniusgym.member.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.geniusgym.databinding.RecycleCellMeShoppingBinding
import com.example.geniusgym.member.model.ClassInfo
import com.example.geniusgym.member.viewmodel.MeRecycShopViewModel

class MeShoppingAdapter(private val shopitems : List<ClassInfo>, private val owner: ViewModelStoreOwner) : RecyclerView.Adapter<MeShoppingAdapter.MyShopingViewHolder>() {

    private lateinit var viewModel: MeRecycShopViewModel
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyShopingViewHolder {
        val binding: RecycleCellMeShoppingBinding = RecycleCellMeShoppingBinding.inflate(
            LayoutInflater.from(parent.context))
        viewModel = ViewModelProvider(owner)[MeRecycShopViewModel::class.java]
//        binding.viewmodel = viewModel
        binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return MyShopingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return shopitems.size
    }

    override fun onBindViewHolder(holder: MyShopingViewHolder, position: Int) {
        viewModel.shopitem.value = shopitems[position]

    }

    class MyShopingViewHolder(val binding: RecycleCellMeShoppingBinding) : RecyclerView.ViewHolder(binding.root)

}