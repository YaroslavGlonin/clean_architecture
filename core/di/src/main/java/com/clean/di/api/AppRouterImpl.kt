package com.clean.di.api

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.clean.navigation.api.AppRouter

class AppRouterImpl:AppRouter {
    private lateinit var navController: NavController

    override fun init(navController: NavController) {
        this.navController = navController
    }

    override fun navigate(navDirections: NavDirections) {
        navController.navigate(navDirections)
    }

    override fun back() {
       navController.popBackStack()
    }
}