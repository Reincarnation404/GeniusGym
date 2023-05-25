package com.example.geniusgym.business

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.business.viewModel.BuMemberDataAddViewModel
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuMemberDataAddBinding

class BuMemberDataAddFragment : Fragment() {

    private lateinit var binding: FragmentBuMemberDataAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuMemberDataAddBinding.inflate(inflater, container, false)
        val viewModel: BuMemberDataAddViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            btBuAddMemDataCancel.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
        }

    }



}