package com.example.androidappbasic.di.modules

import dagger.Module
import dagger.Provides

@Module
object AppModule {
    @Provides
    fun provideString(): String = "1234567890"
}