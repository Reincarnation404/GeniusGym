package com.example.geniusgym.coach.calendarMemberListDetail.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportSmallItem
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberRecordAfterViewModel
import com.example.geniusgym.databinding.FragmentCoCalenderMemberRecordAfterBinding

class CoCalenderMemberRecordAfterFragment : Fragment() {

    private lateinit var binding:FragmentCoCalenderMemberRecordAfterBinding
    private lateinit var item:SportSmallItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoCalenderMemberRecordAfterBinding.inflate(
            inflater,
            container,
            false
        )
        val viewModel : CoCalenderMemberRecordAfterViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            arguments?.let { bundle ->
                bundle.getSerializable("item")?.let{
                    viewModel?.item?.value = it as SportSmallItem
                }
            }
        }
    }

}