package com.example.geniusgym.member

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeCoachInfoBinding

class MeCoachInfoFragment : Fragment() {

    private val viewModel:MeCoachInfoViewModel by viewModels()
    private lateinit var binding: FragmentMeCoachInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeCoachInfoBinding.inflate(LayoutInflater.from(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

            recycMeCoachinfo.adapter = MeCoachInfoAdapter(viewModel.coachinfos!!)
            recycMeCoachinfo.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        }


    }
}