package com.example.androidappbasic.features.home.data.services

import com.example.androidappbasic.features.home.data.models.CommentModel
import com.example.androidappbasic.features.home.domain.entities.MyComment
import retrofit2.http.GET


interface CommentService {
    @GET("comments")
    suspend fun getComments(): List<CommentModel>
}