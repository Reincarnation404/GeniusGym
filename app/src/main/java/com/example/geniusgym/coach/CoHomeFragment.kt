package com.example.geniusgym.coach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.geniusgym.coach.calendarMemberList.viewmodel.CoHomeViewModel
import com.example.geniusgym.databinding.FragmentCoHomeBinding

class CoHomeFragment : Fragment() {

    private lateinit var binding: FragmentCoHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel : CoHomeViewModel by viewModels()
        binding = FragmentCoHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}