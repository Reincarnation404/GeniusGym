package com.example.geniusgym.business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.geniusgym.business.model.testBuCoach
import com.example.geniusgym.business.viewModel.BuCoachViewModel
import com.example.geniusgym.databinding.FragmentBuCoachDataDetailBinding


class BuCoachDataDetailFragment : Fragment() {
    private lateinit var binding: FragmentBuCoachDataDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuCoachDataDetailBinding.inflate(inflater, container, false)
        val viewModel: BuCoachViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let { bundle ->
            bundle.getSerializable("bucoach")?.let {
                binding.viewModel?.coach?.value = it as testBuCoach
                println(bundle)
            }
        }
    }
}