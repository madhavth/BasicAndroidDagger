package com.example.androidappbasic.core.extensions

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String, duration: Int = android.widget.Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}