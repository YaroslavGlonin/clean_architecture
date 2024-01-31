package com.clean.feature_first.api

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavDirections
import com.clean.feature_first.R
import com.clean.feature_first_api.api.FeatureFirstApi

class FeatureFirstApiImpl: FeatureFirstApi {
    override fun navigate(): NavDirections = object : NavDirections {
        override val actionId: Int = R.id.first
        override val arguments: Bundle = bundleOf()
    }
}