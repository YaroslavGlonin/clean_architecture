package com.clean.feature_second.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clean.domain.state.State
import com.clean.feature_second.R
import com.clean.feature_second.databinding.FragmentSecondBinding
import com.clean.navigation.api.AppRouter
import org.koin.android.ext.android.inject
import org.koin.androidx.navigation.koinNavGraphViewModel

class SecondFragment : Fragment() {

    private val appRouter:AppRouter by inject()
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: SecondViewModel by koinNavGraphViewModel(R.id.second)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater,container,false)

        initListeners()
        initObservers()

        return binding.root
    }

    private fun initListeners() {
        binding.buttonNavigate.setOnClickListener {
            appRouter.back()
        }

        binding.button.setOnClickListener {
            viewModel.getData()
        }
    }

    private fun initObservers(){
        viewModel.data.observe(viewLifecycleOwner){
            when(it){
                State.Loading -> TODO()
                is State.error -> binding.textView.text = it.exception.localizedMessage
                is State.success -> binding.textView.text = it.data.fact
            }
        }
    }


}