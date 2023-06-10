package com.example.geniusgym

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geniusgym.databinding.FragmentLoginForgetBinding

class LoginForgetFragment : Fragment() {
    private lateinit var binding: FragmentLoginForgetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginForgetBinding.inflate(inflater, container, false)
        val viewModel: LoginForgetViewModel by viewModels()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            btLoginForgetConfirm.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.meTrainingFirstPageFragment)
            }
        }
    }

}