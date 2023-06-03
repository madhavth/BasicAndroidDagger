package com.example.androidappbasic.features.home.domain.entities

data class MyComment(
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
)