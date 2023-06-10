package com.example.geniusgym.coach

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.geniusgym.R
import com.example.geniusgym.coach.calendarMemberListDetail.model.SportRecordBigItem
import com.example.geniusgym.databinding.ActivityCo2Binding
import com.google.gson.GsonBuilder

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
        this.binding.viewModel?.loadSportFromPreference(this)
        this.binding.viewModel?.loadSportSmallItem()
        this.binding.viewModel?.loadSportBigItem()
        navigateController = findNavController(R.id.fragmentCoContainerView)
        with(binding){
            includeHome.homeMontionLayout.setOnClickListener {
                navigateController.navigate(R.id.coHomeFragment)
            }
            includeCalendar.coachMotionLayout.setOnClickListener {
                navigateController.navigate(R.id.coCalendarTestFragment)
            }
            includeSocial.socialMontionLayout.setOnClickListener {
               // navigateController.navigate(R.id.settingFragment)
            }
            includeNotification.notificationMontionLayout.setOnClickListener {
               navigateController.navigate(R.id.notificationFragment)
            }
            includeMember.memberMontionLayout.setOnClickListener {
                navigateController.navigate(R.id.settingFragment)
            }
            navigateController.addOnDestinationChangedListener{controller, destination, arguments->
                includeHome.homeMontionLayout.progress =0f
                includeCalendar.coachMotionLayout.progress =0f
                includeSocial.socialMontionLayout.progress =0f
                includeNotification.notificationMontionLayout.progress =0f
                includeMember.memberMontionLayout.progress =0f
                when(destination.id){
                    R.id.coHomeFragment -> includeHome.homeMontionLayout.transitionToEnd()
                    R.id.coCalendarTestFragment -> includeCalendar.coachMotionLayout.transitionToEnd()
                    R.id.settingFragment -> includeMember.memberMontionLayout.transitionToEnd()
                    R.id.notificationFragment -> includeNotification.notificationMontionLayout.transitionToEnd()
                }
            }
        }

    }

    override fun onPause() {
        super.onPause()
        val gson = GsonBuilder().create()
        val sportSmallItemsJson = gson.toJson(this.binding.viewModel?.sportSmallItems?.value)
        val sportBigItems = gson.toJson(this.binding.viewModel?.sportBigItems?.value)
        this.getPreferences(Context.MODE_PRIVATE).edit()
            .putString("sportSmallItems",sportSmallItemsJson)
            .putString("sportBigItems", sportBigItems)
            .apply()
        println("Write prefernece successful!")
    }
}