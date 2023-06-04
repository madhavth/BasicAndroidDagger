package com.example.androidappbasic.features.home.domain.repositories

import com.example.androidappbasic.features.home.data.models.CommentModel

interface CommentRepository {
    suspend fun getComments(): List<CommentModel>
}