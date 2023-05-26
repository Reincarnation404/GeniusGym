package com.example.geniusgym.member.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeBranchBinding
import com.example.geniusgym.member.MeBranchAdapter
import com.example.geniusgym.member.viewmodel.MeBranchViewModel

class MeBranchFragment : Fragment() {
    private lateinit var binding: FragmentMeBranchBinding
    private val viewModel: MeBranchViewModel by viewModels()
    private lateinit var controller: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeBranchBinding.inflate(LayoutInflater.from(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.fragmentContainerView2.getFragment<MeBranchDetailFragment>()
        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_me_branch) as NavHostFragment
        val navController = navHostFragment.navController
    }

}