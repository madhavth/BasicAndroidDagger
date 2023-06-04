package com.example.androidappbasic.features.comments.data.di.modules

import com.example.androidappbasic.di.modules.CommentModule
import com.example.androidappbasic.features.comments.data.services.FakeCommentService
import com.example.androidappbasic.features.home.data.services.CommentService
import dagger.Module
import dagger.Provides

@Module(includes=[CommentModule::class])
object FakeCommentModule {
    @Provides
    fun provideCommentService(): CommentService {
        return FakeCommentService()
    }

}