package com.example.geniusgym.business

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R

class BuBusinessDataFragment : Fragment() {

    companion object {
        fun newInstance() = BuBusinessDataFragment()
    }

    private lateinit var viewModel: BuBusinessDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().setTitle(R.string.btBuMenuBusinessDataManage)
        return inflater.inflate(R.layout.fragment_bu_business_data, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BuBusinessDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

}