package com.example.geniusgym.member.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R
import com.example.geniusgym.member.MeNaviDrawerViewModel

class MeNaviDrawer : Fragment() {

    companion object {
        fun newInstance() = MeNaviDrawer()
    }

    private lateinit var viewModel: MeNaviDrawerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.menu.mem_navidrawer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MeNaviDrawerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}