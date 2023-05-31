package com.example.geniusgym

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.geniusgym.databinding.FragmentCoCalenderMemberRecordAllBinding

class CoCalenderMemberRecordAllFragment : Fragment(){
    private lateinit var binding:FragmentCoCalenderMemberRecordAllBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoCalenderMemberRecordAllBinding.inflate(inflater, container, false)
        return binding.root
    }
}

