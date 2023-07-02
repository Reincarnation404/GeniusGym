package com.example.geniusgym.member.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.geniusgym.databinding.FragmentMeHomeBinding
import com.example.geniusgym.member.viewmodel.MeHomeViewModel
import com.example.geniusgym.sharedata.MeShareData.CountDownPerSecond
import com.example.geniusgym.sharedata.MeShareData.CountDownTotalSecond
import com.example.geniusgym.sharedata.MeShareData.LocalDateTimeInitHours
import com.example.geniusgym.sharedata.MeShareData.LocalDateTimeInitMinutes
import com.example.geniusgym.sharedata.MeShareData.LocalDateTimeInitSeconds
import com.example.geniusgym.sharedata.MeShareData.LocalDateTimeToTextFormat
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.time.LocalTime
import java.time.format.DateTimeFormatter


class MeHomeFragment : Fragment(), CoroutineScope by MainScope() {


    private val viewModel: MeHomeViewModel by viewModels()
    private lateinit var binding : FragmentMeHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, 
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeHomeBinding.inflate(LayoutInflater.from(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launch {
            while (true){
                withContext(Dispatchers.Main){
                    binding.ivMeHomeQRcode.setImageBitmap(viewModel.createPic(viewModel.getUrlFromNow()))
                }
                val fiveMinutes = LocalTime.of(LocalDateTimeInitHours, LocalDateTimeInitMinutes, LocalDateTimeInitSeconds)
                val mutex = Mutex()
                var count = 0L
                repeat(CountDownTotalSecond){
                    delay(CountDownPerSecond)
                    mutex.withLock {
                        count++
                    }
                    withContext(Dispatchers.Main){
                        binding.tvMEHomeTimer.text = fiveMinutes.minusSeconds(count).format(DateTimeFormatter.ofPattern(LocalDateTimeToTextFormat))
                    }
                }
                if (count == CountDownTotalSecond.toLong()){
                    withContext(Dispatchers.Main){
                        binding.ivMeHomeQRcode.setImageBitmap(viewModel.createPic(viewModel.getUrlFromNow()))
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cancel()
    }
}