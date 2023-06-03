package com.example.androidappbasic.di.modules

import com.example.androidappbasic.MainActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes =[AndroidInjectionModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}