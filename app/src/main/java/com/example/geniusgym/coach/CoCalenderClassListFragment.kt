package com.example.geniusgym.coach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.coach.calendarMemberList.controller.ClassItemAdapter
import com.example.geniusgym.databinding.FragmentCoCalenderClassListBinding


class CoCalenderClassListFragment : Fragment() {
    private lateinit var binding: FragmentCoCalenderClassListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: CoCalendarClassListViewModel by viewModels()
        binding = FragmentCoCalenderClassListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            rvCoCaClList.layoutManager = LinearLayoutManager(requireContext())
            viewModel?.items?.observe(viewLifecycleOwner){items ->
                if(rvCoCaClList.adapter == null){
                    rvCoCaClList.adapter = ClassItemAdapter(items)
                }else{
                    (rvCoCaClList.adapter as ClassItemAdapter).updateItem(items)
                }
            }
            println(viewModel?.items?.value)
        }
    }
}