package com.fazzaro.dojo.android

import androidx.lifecycle.ViewModel
import com.fazzaro.dojo.android.kata.FizzBuzz
import com.fazzaro.dojo.android.ui.models.FizzBuzzViewModel
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class FizzBuzzViewModelTest {
    private lateinit var fizzbuzz: FizzBuzz
    lateinit var subject: FizzBuzzViewModel

    @BeforeEach
    fun arrange() {
        fizzbuzz = mockk<FizzBuzz>()
        every { fizzbuzz.play(5) } returns "Fuck yeah!"
        subject = FizzBuzzViewModel(fizzbuzz)
    }

    @Test
    fun exists() {
        assertNotNull(subject as? ViewModel)
    }

    @Test
    fun hasResult() {
        assertNull(subject.result)
    }

    @ParameterizedTest(name = "Given {1} sets {0}")
    @CsvSource("2,2","3,3")
    fun `parses numeric input`(expected: Int, input: String) {
        subject.setInput(input)

        assertEquals(expected, subject.input)
        assertTrue(subject.isPlayEnabled)
    }

    @Test
    fun `given a blank string has a null input`() {
        subject.setInput("")

        assertNull(subject.input)
    }

    @Test
    fun `given bad input, sets input to null`() {
        arrangeValidInput()

        subject.setInput("not numeric")

        assertNull(subject.input)
    }

    @Test
    fun `when playing calls the FizzBuzz logic`() {
        subject.setInput("5")
        subject.play()

        verify { fizzbuzz.play(5) }
        assertEquals("Fuck yeah!", subject.result)
    }

    @Test
    fun `with invalid input it does not play FizzBuzz`() {
        subject.setInput("byteme!")
        subject.play()

        verify { fizzbuzz wasNot Called }
    }

    private fun arrangeValidInput() {
        subject.setInput("42")
    }
}