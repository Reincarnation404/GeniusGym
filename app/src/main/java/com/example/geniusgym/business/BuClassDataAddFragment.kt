package com.example.geniusgym.business

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.geniusgym.business.viewModel.BuClassDataAddViewModel
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuClassDataAddBinding

class BuClassDataAddFragment : Fragment() {

    private lateinit var binding: FragmentBuClassDataAddBinding
    private lateinit var viewModel: BuClassDataAddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuClassDataAddBinding.inflate(inflater, container, false)
        val viewModel: BuClassDataAddViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }



}