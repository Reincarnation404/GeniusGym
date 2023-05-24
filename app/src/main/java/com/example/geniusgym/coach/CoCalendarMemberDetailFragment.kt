package com.example.geniusgym.coach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberList.model.MemberItem
import com.example.geniusgym.coach.calendarMemberList.viewmodel.CoCalendarMemberDetailViewModel
import com.example.geniusgym.databinding.FragmentCoCalendarMemberDetailBinding

class CoCalendarMemberDetailFragment : Fragment() {

    private lateinit var binding:FragmentCoCalendarMemberDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel : CoCalendarMemberDetailViewModel by viewModels()
        binding = FragmentCoCalendarMemberDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mainActivity = requireActivity() as CoActivity
        with(binding){
            tvCoCaMeDetail.setOnClickListener{
                println("tvCoCaMeDetail")
                Navigation.findNavController(requireActivity(), R.id.fcvCoCaMe).navigate(R.id.coCalenderMemberStaticFragment)

            }
            tvCoCaMeRecord.setOnClickListener {
                println("tvCoCaMeRecord")
                Navigation.findNavController(requireActivity(), R.id.fcvCoCaMe).navigate(R.id.coCalenderMemberRecordFragment)

            }
        }
        arguments?.let{bundle ->
            bundle.getSerializable("Member")?.let {
                val member = it as MemberItem
                mainActivity.binding.viewModel?.name?.value = member.name
            }
        }
    }
}