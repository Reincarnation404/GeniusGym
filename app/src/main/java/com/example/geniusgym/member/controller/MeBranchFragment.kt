package com.example.geniusgym.member.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeBranchBinding
import com.example.geniusgym.member.viewmodel.MeBranchViewModel

class MeBranchFragment : Fragment() {
    private lateinit var binding: FragmentMeBranchBinding
    private val viewModel: MeBranchViewModel by viewModels()
    private lateinit var navHostFragment : NavHostFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeBranchBinding.inflate(LayoutInflater.from(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navHostFragment = NavHostFragment.create(R.navigation.navigation_me_branch)
        childFragmentManager.beginTransaction()
            .replace(R.id.nav_me_branch, navHostFragment)
            .setPrimaryNavigationFragment(navHostFragment)
            .commit()



    }

    override fun onResume() {
        super.onResume()
        val navController = navHostFragment.navController
    }
}