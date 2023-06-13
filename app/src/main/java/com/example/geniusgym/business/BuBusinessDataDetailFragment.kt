package com.example.geniusgym.business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.geniusgym.business.model.testBuBusiness
import com.example.geniusgym.business.viewModel.BuBusinessViewModel
import com.example.geniusgym.databinding.FragmentBuBusinessDataDetailBinding

class BuBusinessDataDetailFragment : Fragment() {
    private lateinit var binding: FragmentBuBusinessDataDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuBusinessDataDetailBinding.inflate(inflater, container, false)
        val viewModel: BuBusinessViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let { bundle ->
            bundle.getSerializable("bubuz")?.let {
                binding.viewModel?.buz?.value = it as testBuBusiness
                println(bundle)
            }
        }

    }

}