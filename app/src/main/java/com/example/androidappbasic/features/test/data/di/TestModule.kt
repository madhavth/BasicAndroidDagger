package com.example.androidappbasic.features.test.data.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet

@Module
object TestModule {
    @ElementsIntoSet
    @Provides
    fun providesSetString() = setOf("1", "2", "3")

}