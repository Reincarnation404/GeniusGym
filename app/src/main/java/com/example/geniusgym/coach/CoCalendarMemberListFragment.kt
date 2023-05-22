package com.example.geniusgym.coach

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentCoCalendarMemberListBinding

class CoCalendarMemberListFragment : Fragment() {



    private lateinit var binding:FragmentCoCalendarMemberListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel : CoCalendarMemberListViewModel by viewModels()
        binding = FragmentCoCalendarMemberListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let{bundle ->
            bundle.getSerializable("Class")?.let{

            }
        }

    }

}