package com.example.androidappbasic.features.home.data.repositories

import com.example.androidappbasic.features.home.data.data_sources.CommentDataSource
import com.example.androidappbasic.features.home.data.models.CommentModel
import com.example.androidappbasic.features.home.domain.entities.MyComment
import com.example.androidappbasic.features.home.domain.repositories.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentDataSource: CommentDataSource
) : CommentRepository {
    override suspend fun getComments() = commentDataSource.getComments()
}