package com.example.geniusgym.business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.business.adapter.BuMemberDataAdapter
import com.example.geniusgym.business.viewModel.BuMemberDataViewModel
import com.example.geniusgym.databinding.FragmentBuMemberDataBinding

class BuMemberDataFragment : Fragment() {
    private lateinit var binding: FragmentBuMemberDataBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().setTitle(R.string.btBuMenuMemberDataManage)
        binding = FragmentBuMemberDataBinding.inflate(inflater, container, false)
        val viewModel: BuMemberDataViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            rvBuMemberData.layoutManager = LinearLayoutManager(requireContext())
            viewModel?.members?.observe(viewLifecycleOwner) { members ->
                // adapter為null要建立新的adapter；之後只要呼叫updateFriends(friends)即可
                if (rvBuMemberData.adapter == null) {
                    rvBuMemberData.adapter = BuMemberDataAdapter(members)
                } else {
                    (rvBuMemberData.adapter as BuMemberDataAdapter).updateBuMember(members)
                }
            }
            fabBuAddMemberData.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_buMemberData_to_buMemberDataAdd)
            }
        }
    }

}