package com.example.androidappbasic.di.modules

import com.example.androidappbasic.di.scopes.BaseScope
import com.example.androidappbasic.features.home.data.services.CommentService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module(includes = [CommentModule::class])
object AppModule {
    @Provides
    fun provideBaseUrl(): String = "https://jsonplaceholder.typicode.com/"

    @Provides
    fun provideRetrofit(baseUrl: String, moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(
            MoshiConverterFactory.create(moshi)
        )
        .build()

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}