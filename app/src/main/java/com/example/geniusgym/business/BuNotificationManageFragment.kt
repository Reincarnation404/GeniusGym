package com.example.geniusgym.business

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentBuNotificaitonManageBinding

class BuNotificationManageFragment : Fragment() {
    private lateinit var binding: FragmentBuNotificaitonManageBinding
    private lateinit var viewModel: BuNotificationManageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().setTitle(R.string.btBuMenuNotification)
        binding = FragmentBuNotificaitonManageBinding.inflate(inflater, container, false)
        return binding.root
    }


}