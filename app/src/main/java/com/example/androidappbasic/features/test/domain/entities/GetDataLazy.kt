package com.example.androidappbasic.features.test.domain.entities

import javax.inject.Inject
import dagger.Lazy
class GetDataLazy @Inject constructor(
    val data: Lazy<Data>
) {
    fun getData(): String {
        return data.get().toString()
    }
}