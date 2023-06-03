package com.example.androidappbasic.di.components

import android.app.Application
import com.example.androidappbasic.MainActivity
import com.example.androidappbasic.core.MyApplication
import com.example.androidappbasic.di.modules.ActivityModule
import com.example.androidappbasic.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.AndroidInjectionModule

@Component(modules = [AppModule::class, ActivityModule::class])
interface AppComponent: AndroidInjector<MyApplication> {

    // component builder that takes application
    fun inject(application: Application)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder
        fun build(): AppComponent
    }

}