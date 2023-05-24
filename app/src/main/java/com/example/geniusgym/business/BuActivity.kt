package com.example.geniusgym.business

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.example.geniusgym.R
import com.example.geniusgym.databinding.ActivityBuBinding

class BuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBuBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)





    }


}