package com.example.androidappbasic.features.home.presentation.page

import android.os.Bundle
import com.example.androidappbasic.core.extensions.showToast
import com.example.androidappbasic.databinding.ActivityMainBinding
import com.example.androidappbasic.features.home.presentation.view_models.CustomConfig
import com.example.androidappbasic.features.home.presentation.view_models.MainViewModel
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : DaggerActivity() {
    @Inject
    lateinit var value: String

    @Inject
    lateinit var mainViewModelFactory: MainViewModel.MainViewModelFactory

    private val mainViewModel by lazy {
        mainViewModelFactory.create(CustomConfig("value is 1", "value is 2"))
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvTest.text = value
        showToast("$mainViewModel")
    }
}