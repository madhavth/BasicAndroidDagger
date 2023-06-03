package com.example.androidappbasic.features.home.presentation.view_models

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class CustomConfig @AssistedInject constructor(
        @Assisted(VALUE1)  private val passedValue: String,
        @Assisted(VALUE2) private val passedValue2: String
) {
    companion object {
        const val VALUE1 = "value1"
        const val VALUE2 = "value2"
    }

    fun useTheseValues(): String {
        return passedValue + passedValue2
    }

    @AssistedFactory
    interface CustomConfigFactory {
        fun create(@Assisted(VALUE1) passedValue: String,
                   @Assisted(VALUE2) passedValue2: String
        ): CustomConfig
    }
}