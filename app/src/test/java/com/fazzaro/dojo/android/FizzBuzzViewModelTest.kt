package com.fazzaro.dojo.android

import androidx.lifecycle.ViewModel
import com.fazzaro.dojo.android.ui.models.FizzBuzzViewModel
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class FizzBuzzViewModelTest {

    @Test
    fun exists() {
        val subject = FizzBuzzViewModel() as? ViewModel
        assertNotNull(subject)
    }

}