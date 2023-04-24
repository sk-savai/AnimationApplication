package com.example.datafilteringapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.datafilteringapplication.R
import com.example.datafilteringapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener(listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->


            when (destination.id) {
                R.id.menuHomeFragment -> {
                    showBottom()
                }
                R.id.menuAnimationFragment -> {
                    showBottom()
                }
                else -> {
                    hideBottom()
                }
            }
        })


    }

    private fun showBottom() {
        binding.bottomNavigation.isVisible = true
    }

    private fun hideBottom() {
        binding.bottomNavigation.isVisible = false
    }
}