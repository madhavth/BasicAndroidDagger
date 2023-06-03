package com.example.androidappbasic.features.home.domain.entities

sealed class CommentListState {
    object Initial: CommentListState()
    object Loading : CommentListState()
    data class Success(val comments: List<MyComment>) : CommentListState()
    data class Error(val error: String) : CommentListState()
}