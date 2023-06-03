package com.example.androidappbasic.di.components

import com.example.androidappbasic.core.MyApplication
import com.example.androidappbasic.di.modules.ActivityModule
import com.example.androidappbasic.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Component(modules = [AppModule::class, ActivityModule::class])
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder
        fun build(): AppComponent
    }
}