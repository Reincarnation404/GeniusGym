package com.example.geniusgym.business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.business.viewModel.BuCoachDataViewModel
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            fabBuCoachDataAdd.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_buCoachData_to_buCoachDataAdd)
            }
        }
    }


}