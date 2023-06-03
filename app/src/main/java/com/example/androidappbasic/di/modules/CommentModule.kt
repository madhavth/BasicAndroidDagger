package com.example.androidappbasic.di.modules

import com.example.androidappbasic.features.home.data.repositories.CommentRepositoryImpl
import com.example.androidappbasic.features.home.data.services.CommentService
import com.example.androidappbasic.features.home.domain.repositories.CommentRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object CommentModule {
    @Provides
    fun providesCommentRepository(commentRepositoryImpl: CommentRepositoryImpl): CommentRepository =
        commentRepositoryImpl

    @Provides
    fun providesCommentService(retrofit: Retrofit): CommentService =
        retrofit.create(CommentService::class.java)
}