package com.example.androidappbasic.features.home.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappbasic.features.home.domain.entities.CommentListState
import com.example.androidappbasic.features.home.domain.entities.MyComment
import com.example.androidappbasic.features.home.domain.use_cases.CommentUseCases
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class MainViewModel @AssistedInject constructor(
    private var value: String,
    private val commentUseCases: CommentUseCases,
    @Assisted private val customConfig: CustomConfig,
) : ViewModel() {

    private val _comments = MutableStateFlow<CommentListState>(CommentListState.Initial)
    val commentListState = _comments.asStateFlow()

    private fun useValue(): String {
        return customConfig.useTheseValues()
    }

    override fun toString(): String {
        return "MainViewModel(value='$value') ${useValue()}"
    }

    @AssistedFactory
    interface MainViewModelFactory {
        fun create(customConfig: CustomConfig): MainViewModel
    }

    init {
        loadComments()
    }
    fun loadComments() {
        viewModelScope.launch {
            _comments.value = CommentListState.Loading
            try {
                val commentsList = commentUseCases.getCommentsUseCase.execute()
                _comments.value = CommentListState.Success(commentsList)
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                _comments.value = CommentListState.Error(e.toString())
            }
        }
    }
}
