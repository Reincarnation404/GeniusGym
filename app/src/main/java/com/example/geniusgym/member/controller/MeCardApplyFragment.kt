package com.example.geniusgym.member.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R
import com.example.geniusgym.member.MeCardApplyViewModel

class MeCardApply : Fragment() {

    companion object {
        fun newInstance() = MeCardApply()
    }

    private lateinit var viewModel: MeCardApplyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_me_card_apply, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MeCardApplyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}