package com.example.geniusgym.coach

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordBigItem
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordItem
import com.example.geniusgym.databinding.ActivityCo2Binding

class CoActivity : AppCompatActivity() {

    public lateinit var binding: ActivityCo2Binding
    private lateinit var navigateController: NavController
    public var memberSportRecord =  mutableListOf<SportRecordBigItem>()
    public var memberSportBigRecord : SportRecordBigItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : CoViewModel by viewModels()
        binding = ActivityCo2Binding.inflate(LayoutInflater.from(this))
        binding.viewModel = viewModel
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
                navigateController.navigate(R.id.coCalendarTestFragment)
            }
            includeSocial.socialMontionLayout.setOnClickListener {
                navigateController.navigate(R.id.settingFragment)
            }
            includeNotification.notificationMontionLayout.setOnClickListener {
               /* navigateController.navigate(R.id.coCalenderMemberStaticFragment)*/
            }
        }
    }
}