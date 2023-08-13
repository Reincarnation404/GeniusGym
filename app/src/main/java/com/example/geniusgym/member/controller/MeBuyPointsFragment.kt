package com.example.geniusgym.member.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeBuyPointsBinding
import com.example.geniusgym.databinding.RecycleMeBuyPointsBinding
import com.example.geniusgym.member.MePointsViewModel
import com.example.geniusgym.member.adapter.MeBuyPointsAdapter
import com.example.geniusgym.member.viewmodel.MeBuyPointsViewModel

class MeBuyPointsFragment : Fragment() {
    private lateinit var binding: RecycleMeBuyPointsBinding
    private lateinit var adapter: MeBuyPointsAdapter
    private lateinit var viewModel: MeBuyPointsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 創建一個 MeBuyPointsViewModel 的實例，並將它賦值給 viewModel 變數
        viewModel = ViewModelProvider(this)[MeBuyPointsViewModel::class.java]
        // 使用 RecycleMeBuyPointsBinding 來填充佈局
        binding = RecycleMeBuyPointsBinding.inflate(inflater,container,false)
        // 將 ViewModel 賦值給綁定的 viewModel 變數
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 創建一個 MeBuyPointsAdapter 的實例，並使用 viewModel 的 buypoints 數據來初始化
        adapter = MeBuyPointsAdapter(binding.viewmodel!!.buypoints)
        // 設置 RecyclerView 的佈局管理器為線性佈局管理器
        binding.btRecyclerlist.layoutManager = LinearLayoutManager(requireContext())
        // 設置 RecyclerView 的適配器為剛剛建立的 adapter
        binding.btRecyclerlist.adapter = adapter
    }

}