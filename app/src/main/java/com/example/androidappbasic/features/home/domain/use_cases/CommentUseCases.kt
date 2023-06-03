package com.example.androidappbasic.features.home.domain.use_cases

import javax.inject.Inject

class CommentUseCases @Inject constructor(
    val getCommentsUseCase: GetCommentsUseCase
)