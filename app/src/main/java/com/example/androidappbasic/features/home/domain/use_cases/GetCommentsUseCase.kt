package com.example.androidappbasic.features.home.domain.use_cases

import com.example.androidappbasic.features.home.domain.entities.MyComment
import com.example.androidappbasic.features.home.domain.repositories.CommentRepository
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
    private val commentRepository: CommentRepository
) {
    suspend fun execute(): List<MyComment> = commentRepository.loadComments().map {
        it.toEntity()
    }
}