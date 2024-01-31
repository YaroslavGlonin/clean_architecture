package com.clean.feature_second.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.domain.model.Fact
import com.clean.domain.state.State
import com.clean.domain.usecase.MainUseCase
import kotlinx.coroutines.launch

class SecondViewModel(
    private val mainUseCase: MainUseCase
) : ViewModel() {
    private val _data: MutableLiveData<State<Fact>> = MutableLiveData()
    val data: LiveData<State<Fact>> = _data

    fun getData(){
        viewModelScope.launch {
           _data.value = State.on { mainUseCase.execute() }
        }
    }
}