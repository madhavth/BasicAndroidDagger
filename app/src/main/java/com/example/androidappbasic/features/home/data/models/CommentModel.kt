package com.example.androidappbasic.features.home.data.models

import com.example.androidappbasic.features.home.domain.entities.MyComment

data class CommentModel(
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
) {
    fun toEntity(): MyComment {
        return MyComment(
            id = id,
            postId = postId,
            name = name,
            email = email,
            body = body
        )
    }

}