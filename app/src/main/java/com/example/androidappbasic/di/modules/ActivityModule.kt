package com.example.androidappbasic.di.modules

import com.example.androidappbasic.features.home.presentation.page.MainActivity
import com.example.androidappbasic.features.test.presentation.page.TestActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes =[AndroidInjectionModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributesTestActivity(): TestActivity
}