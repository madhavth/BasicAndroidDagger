package com.example.androidappbasic

import android.os.Bundle
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : DaggerActivity() {
    @Inject
    lateinit var value: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        print(value)
        setContentView(R.layout.activity_main)
    }
}