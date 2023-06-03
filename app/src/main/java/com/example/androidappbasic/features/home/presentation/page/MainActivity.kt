package com.example.androidappbasic.features.home.presentation.page

import android.os.Bundle
import com.example.androidappbasic.databinding.ActivityMainBinding
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : DaggerActivity() {
    @Inject
    lateinit var value: String

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvTest.text = value
    }
}