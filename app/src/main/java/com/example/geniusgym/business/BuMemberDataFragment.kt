package com.example.geniusgym.business

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuMemberDataBinding

class BuMemberDataFragment : Fragment() {
    private lateinit var binding: FragmentBuMemberDataBinding
    private lateinit var viewModel: BuMemberDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().setTitle(R.string.btBuMenuMemberDataManage)
        binding = FragmentBuMemberDataBinding.inflate(inflater, container, false)
        return binding.root
    }

}