package com.example.geniusgym.coach

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.geniusgym.coach.calendarMemberList.viewmodel.CoHomeViewModel
import com.example.geniusgym.databinding.FragmentCoHomeBinding

class CoHomeFragment : Fragment() {

    private lateinit var binding: FragmentCoHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: CoHomeViewModel by viewModels()
        binding = FragmentCoHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val second = 1000L
        val minute = 60 * second
        val timer = object : CountDownTimer(5 * minute, 1 * second) {
            // 每過一秒，該方法會被呼叫一次
            override fun onTick(millisUntilFinished: Long) {
                val secondsUntilFinished = millisUntilFinished / second

            }

            // 計時器結束時，該方法會被呼叫
            override fun onFinish() {

            }
        }
        timer.start() // 開始計時

    }
}