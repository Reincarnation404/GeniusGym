package com.example.geniusgym.member

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.geniusgym.R
import com.example.geniusgym.databinding.ActivityMeBinding

class MeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMeBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val destinationMap = mapOf(
            R.id.meHomeFragment to binding.includedHome.homeMontionLayout,
            R.id.meBranchFragment to binding.includedBranch.branchMontionLayout,
            R.id.socialFragment to binding.includedSocial.socialMontionLayout,
            R.id.notificationFragment to binding.includedNotification.notificationMontionLayout,
            R.id.meMemberFragment to binding.includedMember.memberMontionLayout,
            R.id.settingFragment to binding.includedSetting.settingMontionLayout

        )

        setupActionBarWithNavController(
            navController,
            AppBarConfiguration(destinationMap.keys)
        )
        destinationMap.forEach{map ->
            map.value.setOnClickListener {
                navController.navigate(map.key)
            }
        }

        navController.addOnDestinationChangedListener{controller, destination, argument ->

            controller.popBackStack()
            destinationMap.values.forEach{it.progress = 0f}
            destinationMap[destination.id]?.transitionToEnd()

        }
    }
}