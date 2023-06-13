package com.example.geniusgym.member.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.geniusgym.R
import com.example.geniusgym.databinding.FragmentMeHomeBinding
import com.example.geniusgym.member.viewmodel.MeHomeViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder


class MeHomeFragment : Fragment() {


    private val viewModel: MeHomeViewModel by viewModels()
    private lateinit var binding : FragmentMeHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMeHomeBinding.inflate(LayoutInflater.from(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val encoder = BarcodeEncoder()
        try {
            val bitmap = encoder.encodeBitmap("http://192.168.186.96:8080/THP101", BarcodeFormat.QR_CODE, 380, 380)
            binding.ivMeHomeQRcode.setImageBitmap(bitmap)
        }catch (e : WriterException){
            e.printStackTrace()
        }

    }
}