package com.example.geniusgym.coach.calendarMemberListDetail.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.geniusgym.coach.CoActivity
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportSmallItem
import com.example.geniusgym.coach.calendarMemberListDetail.viewmodel.CoCalenderMemberRecordAfterViewModel
import com.example.geniusgym.databinding.FragmentCoCalenderMemberRecordAfterBinding

class CoCalenderMemberRecordAfterFragment : Fragment() {

    private lateinit var binding: FragmentCoCalenderMemberRecordAfterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoCalenderMemberRecordAfterBinding.inflate(
            inflater,
            container,
            false
        )
        val viewModel: CoCalenderMemberRecordAfterViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coActivity = requireActivity() as CoActivity
        with(binding) {
            arguments?.let { bundle ->
                bundle.getSerializable("item")?.let {
                    viewModel?.sc_id = (it as SportSmallItem).id
                    viewModel?.sportName?.value = it.name
                }
            }
            val member = coActivity.binding.viewModel?.member?.value
            member?.let {
                viewModel?.m_id = member.memberId
                viewModel?.name?.value = member.name
            }
        }
    }
}