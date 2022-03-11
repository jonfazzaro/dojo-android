package com.fazzaro.dojo.android

import androidx.lifecycle.ViewModel
import com.fazzaro.dojo.android.kata.FizzBuzz
import com.fazzaro.dojo.android.ui.models.FizzBuzzViewModel
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
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
        Dispatchers.setMain(mainThreadSurrogate)
        fizzbuzz = mockk<FizzBuzz>()
        coEvery { fizzbuzz.play(5) } returns "Buzz"
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
    @CsvSource("2,2", "3,3")
    fun `parses numeric input`(expected: Int, input: String) {
        subject.setInput(input)

        assertEquals(expected, subject.input)
        assertTrue(subject.isPlayEnabled)
    }

    @Test
    fun `given a blank string has a null input`() {
        arrangeValidInput()

        subject.setInput("")

        assertNull(subject.input)
    }

    @Test
    fun `given bad input, sets input to null`() {
        arrangeValidInput()

        subject.setInput("not numeric")

        assertNull(subject.input)
    }

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Test
    fun `when playing calls the FizzBuzz logic`() = runBlockingTest {
        launch(Dispatchers.Main) {
            subject.setInput("5")
            subject.play()

            coVerify { fizzbuzz.play(5) }
//        assertEquals("The FizzBuzz of 5 is Buzz", subject.result)
//        assertNull(subject.input)
//        assertFalse(subject.isPlayEnabled)
        }
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
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