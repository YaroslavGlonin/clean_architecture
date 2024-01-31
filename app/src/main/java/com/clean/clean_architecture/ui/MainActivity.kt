package com.clean.clean_architecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.clean.clean_architecture.R
import com.clean.clean_architecture.databinding.ActivityMainBinding
import com.clean.navigation.api.AppRouter
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val appRouter: AppRouter by inject()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = binding.mainContainer.getFragment<NavHostFragment>().navController
        navController.graph = navController.navInflater.inflate(R.navigation.main)
        appRouter.init(navController)
    }
}