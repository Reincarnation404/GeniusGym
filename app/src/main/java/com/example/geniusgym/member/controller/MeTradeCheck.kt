package com.example.geniusgym.member.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R
import com.example.geniusgym.member.MeTradeCheckViewModel

class MeTradeCheck : Fragment() {

    // 定義一個 companion object，用於創建 fragment 的實例
    companion object {
        fun newInstance() = MeTradeCheck()
    }

    private lateinit var viewModel: MeTradeCheckViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_me_trade_check, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // 創建 MeTradeCheckViewModel 實例並與 ViewModelProvider 關聯
        viewModel = ViewModelProvider(this).get(MeTradeCheckViewModel::class.java)
        // TODO: Use the ViewModel
    }

}