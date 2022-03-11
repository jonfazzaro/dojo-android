package com.fazzaro.dojo.android.ui.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fazzaro.dojo.android.kata.FizzBuzz
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class FizzBuzzViewModel(private val fizzbuzz: FizzBuzz = FizzBuzz()) : ViewModel() {

    var isPlayEnabled: Boolean by mutableStateOf(false)
        private set

    // TODO how to test drive this???
    var input: Int? by mutableStateOf(null)
        private set

    var result: String? by mutableStateOf(null)
        private set

    fun setInput(inputValue: String) {
        input = inputValue.toIntOrNull()
        isPlayEnabled = input != null
    }

    fun play() {
        viewModelScope.async {
            input?.let {
                result = "The FizzBuzz of $it is ${fizzbuzz.play(it)}"
                input = null
                isPlayEnabled = false
            }
        }
    }
}
