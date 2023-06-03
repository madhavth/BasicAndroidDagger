package com.example.androidappbasic.features.home.data.data_sources

import com.example.androidappbasic.features.home.data.services.CommentService
import javax.inject.Inject

class CommentDataSource @Inject constructor(
    private val commentService: CommentService
){
    suspend fun getComments() = commentService.getComments()
}