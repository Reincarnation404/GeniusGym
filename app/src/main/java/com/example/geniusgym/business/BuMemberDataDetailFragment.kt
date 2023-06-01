package com.example.geniusgym.business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.geniusgym.business.model.testBuMember
import com.example.geniusgym.business.viewModel.BuMemberViewModel
import com.example.geniusgym.databinding.FragmentBuMemberDataDetailBinding

class BuMemberDataDetailFragment : Fragment() {
    private lateinit var binding: FragmentBuMemberDataDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuMemberDataDetailBinding.inflate(inflater, container, false)
        val viewModel: BuMemberViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let { bundle ->
            bundle.getSerializable("bumember")?.let {
                binding.viewModel?.member?.value = it as testBuMember
                println(bundle)
            }
        }

    }
}