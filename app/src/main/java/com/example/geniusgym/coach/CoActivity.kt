package com.example.geniusgym.coach

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.geniusgym.R
import com.example.geniusgym.databinding.ActivityCo2Binding

class CoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCo2Binding
    private lateinit var navigateController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCo2Binding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        navigateController = findNavController(R.id.fragmentCoContainerView)
        with(binding){
            includeHome.homeMontionLayout.setOnClickListener {
                navigateController.navigate(R.id.coHomeFragment)
            }
            includeCalendar.coachMotionLayout.setOnClickListener {
                navigateController.navigate(R.id.coCalendarFragment)
            }
        }
    }
}