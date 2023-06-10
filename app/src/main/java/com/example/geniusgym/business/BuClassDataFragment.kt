package com.example.geniusgym.business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.business.viewModel.BuClassDataViewModel
import com.example.geniusgym.databinding.FragmentBuClassDataBinding

class BuClassDataFragment : Fragment() {
    private lateinit var binding: FragmentBuClassDataBinding
    private lateinit var viewModel: BuClassDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().setTitle(R.string.btBuMenuClassDataManage)
        binding = FragmentBuClassDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            fabBuClassDataAdd.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_buClassData_to_buClassDataAdd)
            }
        }
    }


}