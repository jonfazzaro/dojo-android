package com.fazzaro.dojo.android.ui.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FizzBuzzViewModel() : ViewModel() {
    var result: String? by mutableStateOf("")
        private set

    fun setInput(input: String) {
        result = input
    }

}
