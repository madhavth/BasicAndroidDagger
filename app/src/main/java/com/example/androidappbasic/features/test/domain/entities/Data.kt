package com.example.androidappbasic.features.test.domain.entities

import javax.inject.Inject
import kotlin.random.Random

class Data @Inject constructor() {
    val id: Int = Random(System.currentTimeMillis()).nextInt(1000) + 1
    override fun toString(): String {
        return "Data:- $id"
    }
}