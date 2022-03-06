package com.fazzaro.dojo.android.ui.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fazzaro.dojo.android.kata.FizzBuzz

class FizzBuzzViewModel(val fizzBuzz: FizzBuzz = FizzBuzz()) : ViewModel() {
    var result: String? by mutableStateOf("")
        private set

    var showResult by mutableStateOf(false)
        private set

    var buttonIsEnabled by mutableStateOf(false)
        private set

    var input: Int? by mutableStateOf(null)
        private set

    fun setInput(input: String) {
        try {
            this.input = Integer.parseInt(input)
            enableForm(true)
        } catch (e: NumberFormatException) {
            this.input = null
            enableForm(false)
        }
    }

    fun play() {
        input?.let {
            result = "The FizzBuzz of $it is ${fizzBuzz.play(it)}."
        }
    }

    private fun enableForm(enable: Boolean) {
        buttonIsEnabled = enable
        showResult = enable
    }

}
