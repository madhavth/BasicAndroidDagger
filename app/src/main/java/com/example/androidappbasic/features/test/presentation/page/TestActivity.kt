package com.example.androidappbasic.features.test.presentation.page

import android.os.Bundle
import com.example.androidappbasic.databinding.ActivityTest2Binding
import com.example.androidappbasic.features.test.domain.entities.Data
import com.example.androidappbasic.features.test.domain.entities.GetNewData
import com.example.androidappbasic.features.test.domain.entities.GetDataLazy
import com.example.androidappbasic.features.test.presentation.view_models.TestViewModel
import dagger.android.DaggerActivity
import javax.inject.Inject

class TestActivity : DaggerActivity() {
    private var _binding: ActivityTest2Binding? = null

    private val binding get() = _binding!!

    @Inject
    lateinit var testViewModel: TestViewModel

    @Inject
    lateinit var getListData: GetNewData

    @Inject
    lateinit var getListDataLazy: GetDataLazy

    @Inject
    lateinit var dataSet: Set<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvProvider.text = getListData.getData()
        binding.btnProvider.setOnClickListener {
            binding.tvProvider.text = getListData.getData()
        }

        binding.tvLazy.text = getListDataLazy.getData()
        binding.btnLazy.setOnClickListener {
            binding.tvLazy.text = getListDataLazy.getData()
        }

        binding.tvLazy.text = dataSet.toString()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}