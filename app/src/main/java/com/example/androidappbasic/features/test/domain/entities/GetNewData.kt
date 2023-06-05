package com.example.androidappbasic.features.test.domain.entities

import javax.inject.Inject
import javax.inject.Provider

class GetNewData @Inject constructor(
    val data: Provider<Data>
) {
    fun getData(): String {
        return data.get().toString()
    }
}
