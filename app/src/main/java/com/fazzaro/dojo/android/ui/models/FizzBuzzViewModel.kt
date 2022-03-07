package com.fazzaro.dojo.android.ui.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fazzaro.dojo.android.kata.FizzBuzz

class FizzBuzzViewModel(val fizzbuzz: FizzBuzz = FizzBuzz()) : ViewModel() {

    var isPlayEnabled = false

    // TODO how to test drive this???
    var input: Int? by mutableStateOf(null)
        private set

    var result: String? = null

    fun setInput(inputValue: String) {
        inputValue.ifEmpty { return }
        input = inputValue.toIntOrNull()
        isPlayEnabled = input != null
    }

    fun play() {
        input?.let { this.fizzbuzz.play(it) }
    }
}
