package com.example.geniusgym.member.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R
import com.example.geniusgym.member.MeCardPaymentViewModel

class MeCardPayment : Fragment() {

    // 使用 companion object 創建一個靜態的 companion 物件
    companion object {
        // 定義一個靜態的方法 newInstance，用於創建此 Fragment 的實例
        fun newInstance() = MeCardPayment()
    }

    // 延遲初始化一個 MeCardPaymentViewModel 的實例
    private lateinit var viewModel: MeCardPaymentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 使用 inflater 將佈局 R.layout.fragment_me_card_payment 填充到視圖中，並返回該視圖
        return inflater.inflate(R.layout.fragment_me_card_payment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MeCardPaymentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}