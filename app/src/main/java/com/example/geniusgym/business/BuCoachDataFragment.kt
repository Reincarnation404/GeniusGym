package com.example.geniusgym.business

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuCoachDataBinding

class BuCoachDataFragment : Fragment() {
    private lateinit var binding: FragmentBuCoachDataBinding
    private lateinit var viewModel: BuCoachDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().setTitle(R.string.btBuMenuCoachDataManage)
        binding = FragmentBuCoachDataBinding.inflate(inflater, container, false)
        return binding.root
    }


}