package com.example.geniusgym.member

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R

class MeTrainingAerobicFragment : Fragment() {

    companion object {
        fun newInstance() = MeTrainingAerobicFragment()
    }

    private lateinit var viewModel: MeTrainingAerobicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_me_training_aerobic, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MeTrainingAerobicViewModel::class.java)
        // TODO: Use the ViewModel
    }

}