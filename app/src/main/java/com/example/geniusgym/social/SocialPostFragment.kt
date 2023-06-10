package com.example.geniusgym.social

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentSocialPostBinding

class SocialPostFragment : Fragment() {

    private lateinit var binding: FragmentSocialPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSocialPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            turnLeft.setOnClickListener {
                navigateTo(R.id.action_socialPostFragment_to_socialHomeFragment)
            }
        }
    }

    private fun navigateTo(actionId: Int) {
        Navigation.findNavController(requireView()).navigate(actionId)
    }
}