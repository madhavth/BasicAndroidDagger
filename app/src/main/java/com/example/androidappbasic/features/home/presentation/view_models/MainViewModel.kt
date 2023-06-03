package com.example.androidappbasic.features.home.presentation.view_models

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

class MainViewModel @AssistedInject constructor(
        private var value: String,
        @Assisted private val customConfig: CustomConfig
) : ViewModel() {
    private fun useValue(): String {
        return customConfig.useTheseValues()
    }

    override fun toString(): String {
        return "MainViewModel(value='$value') ${useValue()}"
    }

    @AssistedFactory
    interface MainViewModelFactory {
        fun create(customConfig: CustomConfig): MainViewModel
    }
}
