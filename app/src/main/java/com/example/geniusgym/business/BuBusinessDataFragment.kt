package com.example.geniusgym.business

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.business.viewModel.BuBusinessDataViewModel
import com.example.geniusgym.databinding.FragmentBuBusinessDataBinding

class BuBusinessDataFragment : Fragment() {
    private lateinit var binding: FragmentBuBusinessDataBinding
    private lateinit var viewModel: BuBusinessDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().setTitle(R.string.btBuMenuBusinessDataManage)
        binding = FragmentBuBusinessDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            fabBuBusinessDataAdd.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_buBusinessData_to_buBusinessDataAdd)
            }
        }
    }



}