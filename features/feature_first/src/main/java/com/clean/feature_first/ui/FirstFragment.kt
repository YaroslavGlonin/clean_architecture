package com.clean.feature_first.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clean.feature_first.databinding.FragmentFirstBinding
import com.clean.feature_second_api.api.FeatureSecondApi
import com.clean.navigation.api.AppRouter
import org.koin.android.ext.android.inject

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val appRouter: AppRouter by inject()
    private val featureSecondApi: FeatureSecondApi by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.button.setOnClickListener {
            appRouter.navigate(featureSecondApi.start())
        }
    }



}