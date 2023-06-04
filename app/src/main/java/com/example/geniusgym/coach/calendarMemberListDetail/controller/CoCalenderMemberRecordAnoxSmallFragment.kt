package com.example.geniusgym.coach.calendarMemberListDetail.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberRecordAnoxSmallViewModel
import com.example.geniusgym.databinding.FragmentCoCalenderMemberRecordAnoxSmallBinding

class CoCalenderMemberRecordAnoxSmallFragment : Fragment() {
    private lateinit var binding: FragmentCoCalenderMemberRecordAnoxSmallBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val viewModel: CoCalenderMemberRecordAnoxSmallViewModel by viewModels()
        binding = FragmentCoCalenderMemberRecordAnoxSmallBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            arguments?.let { bundle ->
                bundle.getSerializable("id")?.let {
                    val id = it as String
                    println("id =" + id)
                    viewModel?.search(id)
                }
            }
            rvCoCaMeReAnSmall.layoutManager = LinearLayoutManager(requireContext())
            viewModel?.items?.observe(viewLifecycleOwner) { items ->
                if (rvCoCaMeReAnSmall.adapter == null) {
                    rvCoCaMeReAnSmall.adapter = CoCaMeReAnSmallAdapter(items)
                } else {
                    (rvCoCaMeReAnSmall.adapter as CoCaMeReAnSmallAdapter).update(items)
                }
            }
        }
    }
}