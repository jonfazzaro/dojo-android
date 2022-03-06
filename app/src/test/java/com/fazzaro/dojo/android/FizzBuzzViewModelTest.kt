package com.fazzaro.dojo.android

import com.fazzaro.dojo.android.ui.models.FizzBuzzViewModel
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class FizzBuzzViewModelTest {

    @Test
    fun exists() {
        val subject = FizzBuzzViewModel()
        assertNotNull(subject)
    }
}