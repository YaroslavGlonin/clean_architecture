package com.clean.feature_second.api

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavDirections
import com.clean.feature_second.R
import com.clean.feature_second_api.api.FeatureSecondApi

class FeatureSecondApiImpl: FeatureSecondApi {
    override fun start(): NavDirections = object : NavDirections {
        override val actionId: Int = R.id.second
        override val arguments: Bundle = bundleOf()
    }
}