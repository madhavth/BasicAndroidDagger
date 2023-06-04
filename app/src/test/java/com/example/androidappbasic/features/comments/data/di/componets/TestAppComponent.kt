package com.example.androidappbasic.features.comments.data.di.componets

import android.app.Application
import android.content.Context
import com.example.androidappbasic.di.components.AppComponent
import com.example.androidappbasic.di.modules.AppModule
import com.example.androidappbasic.features.comments.data.di.modules.FakeCommentModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        FakeCommentModule::class,
        AndroidInjectionModule::class,
        AppModule::class
    ]
)
interface TestAppComponent : AndroidInjector<Application> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): TestAppComponent
    }
}