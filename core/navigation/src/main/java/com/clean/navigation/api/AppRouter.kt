package com.clean.navigation.api

import androidx.navigation.NavController
import androidx.navigation.NavDirections

interface AppRouter {
    fun init(navController: NavController)
    fun navigate(navDirections: NavDirections)
    fun back()
}