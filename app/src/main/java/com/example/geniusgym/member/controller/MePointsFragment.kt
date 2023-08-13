package com.example.geniusgym.member.controller

import android.os.Binder
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMePointsBinding
import com.example.geniusgym.member.MePointsViewModel
import com.example.geniusgym.member.adapter.MePointsAdapter
import com.example.geniusgym.sharedata.MeShareData


class MePointsFragment : Fragment() {
    //初始化
    private lateinit var binding : FragmentMePointsBinding
    private lateinit var adapter: MePointsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 創建 MePointsViewModel 實例並與 ViewModelProvider 關聯
        val viewModel = ViewModelProvider(this)[MePointsViewModel::class.java]

        // 創建並設置 FragmentMePointsBinding
        binding = FragmentMePointsBinding.inflate(inflater,container,false)
        binding.viewmodel = viewModel

        // 設置 ViewModel 的 pointsLiveData 數據為 MeShareData 中的 personPoint
        viewModel.pointsLiveData.value = MeShareData.personPoint
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 創建並設置 MePointsAdapter
        adapter = MePointsAdapter(binding.viewmodel!!.mepointitem)
        // 設置 RecyclerView 的佈局管理器
        binding.ptRecyclerlist.layoutManager = LinearLayoutManager(requireContext())
        // 將適配器設置給 RecyclerView
        binding.ptRecyclerlist.adapter = adapter

        // 獲取導航圖控制器
        val navController = findNavController()
        // 設置點擊事件監聽器，當按鈕被點擊時進行導航到 meBuyPointsFragment2
        binding.btTopup.setOnClickListener {
            navController.navigate(R.id.meBuyPointsFragment2)

        }
    }
}















