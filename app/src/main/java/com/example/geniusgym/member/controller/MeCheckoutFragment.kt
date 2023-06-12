package com.example.geniusgym.member.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R

import com.example.geniusgym.member.viewmodel.MeCheckoutViewModel


class MeCheckoutFragment : Fragment() {

    companion object {
        fun newInstance() = MeCheckoutFragment()
    }

    private lateinit var viewModel: MeCheckoutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_me_checkout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MeCheckoutViewModel::class.java)
        // TODO: Use the ViewModel
    }

}