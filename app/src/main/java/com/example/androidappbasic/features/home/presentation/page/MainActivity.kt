package com.example.androidappbasic.features.home.presentation.page

import android.os.Bundle
import android.view.View
import com.example.androidappbasic.core.extensions.showToast
import com.example.androidappbasic.databinding.ActivityMainBinding
import com.example.androidappbasic.features.home.domain.entities.CommentListState
import com.example.androidappbasic.features.home.presentation.view_models.CustomConfig
import com.example.androidappbasic.features.home.presentation.view_models.MainViewModel
import com.example.androidappbasic.features.home.presentation.adapter.CommentListAdapter
import dagger.android.DaggerActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : DaggerActivity() {
    @Inject
    lateinit var value: String

    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    @Inject
    lateinit var mainViewModelFactory: MainViewModel.MainViewModelFactory

    private val mainViewModel by lazy {
        mainViewModelFactory.create(CustomConfig("value is 1", "value is 2"))
    }

    private lateinit var binding: ActivityMainBinding

    private val commentListAdapter = CommentListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showToast("$mainViewModel")
        initRecyclerView()
        listenToState()
    }

    private fun listenToState() {
        coroutineScope.launch {
            mainViewModel.commentListState.collect {

                binding.apply {
                    rvComment.visibility =
                        if (it is CommentListState.Success) View.VISIBLE else View.GONE
                    progressBar.visibility =
                        if (it is CommentListState.Loading) View.VISIBLE else View.GONE
                    tvTest.visibility =
                        if (it is CommentListState.Initial || it is CommentListState.Error)
                            View.VISIBLE else View.GONE
                }

                when (it) {
                    is CommentListState.Error -> {
                        binding.tvTest.text = it.error
                    }

                    CommentListState.Initial -> {
                        binding.tvTest.text = value
                    }

                    is CommentListState.Success -> {
                        commentListAdapter.submitList(it.comments)
                    }

                    is CommentListState.Loading -> {
                    }
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    private fun initRecyclerView() {
        binding.rvComment.adapter = commentListAdapter
    }
}