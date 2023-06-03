package com.example.androidappbasic.core

import android.content.Context
import com.example.androidappbasic.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {
    private val appComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}