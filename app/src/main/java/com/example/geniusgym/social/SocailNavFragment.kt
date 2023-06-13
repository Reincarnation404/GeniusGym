package com.example.geniusgym.social

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.geniusgym.R

class SocailNavFragment : Fragment() {

    private val viewModel: SocailNavViewModel by viewModels()
    private lateinit var navHostFragment : NavHostFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_socail_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navHostFragment = NavHostFragment.create(R.navigation.social_navigation)
        childFragmentManager.beginTransaction()
            .replace(R.id.navigation_me_social, navHostFragment)
            .setPrimaryNavigationFragment(navHostFragment)
            .commit()

    }

}