package com.example.androidappbasic.features.test.presentation.view_models

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class TestViewModel @Inject constructor() : ViewModel() {
    fun test() {
        println("test")
    }
}