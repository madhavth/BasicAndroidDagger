package com.example.androidappbasic.features.comments.data.services

import com.example.androidappbasic.features.home.data.models.CommentModel
import com.example.androidappbasic.features.home.data.services.CommentService

class FakeCommentService : CommentService {
    override suspend fun getComments(): List<CommentModel> {
        return buildList {
            for (i in 1..100) {
                add(CommentModel(i, i, "email $i", "body $i", "body $i"))
            }
        }
    }
}