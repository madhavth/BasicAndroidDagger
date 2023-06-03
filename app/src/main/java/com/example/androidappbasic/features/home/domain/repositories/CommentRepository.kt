package com.example.androidappbasic.features.home.domain.repositories

import com.example.androidappbasic.features.home.data.models.CommentModel
import com.example.androidappbasic.features.home.domain.entities.MyComment

interface CommentRepository {
    suspend fun loadComments(): List<CommentModel>
}