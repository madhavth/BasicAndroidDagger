package com.example.androidappbasic.features.comments.data.repositories

import com.example.androidappbasic.features.home.domain.repositories.CommentRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import javax.inject.Inject

class CommentRepositoryTest {
    @Inject
    lateinit var commentRepository: CommentRepository

    @Test
    fun testCommentsFetch() = runBlocking {
        val comments = commentRepository.getComments()
        assert(comments.isNotEmpty())
    }
}