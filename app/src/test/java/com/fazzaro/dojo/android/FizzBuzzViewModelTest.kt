package com.fazzaro.dojo.android

import com.fazzaro.dojo.android.kata.FizzBuzz
import com.fazzaro.dojo.android.ui.models.FizzBuzzViewModel
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*

class FizzBuzzViewModelTest {

    private lateinit var fizzBuzz: FizzBuzz
    private lateinit var subject: FizzBuzzViewModel

    @BeforeEach
    fun arrange() {
        fizzBuzz = mockk<FizzBuzz>()
        subject = FizzBuzzViewModel(fizzBuzz)
        every { fizzBuzz.play(any()) } returns "fake!"
    }

    @Test
    fun givenANonNumericInput_disablesTheButtonAndHidesTheResult() {
        subject.setInput("woiefj")
        assertFalse(subject.buttonIsEnabled)
        assertFalse(subject.showResult)
    }

    @Test
    fun givenANumericInput_enablesTheButton() {
        subject.setInput("5")
        assertTrue(subject.buttonIsEnabled)
    }

    @Test
    fun givenANonNumeric_whenPlaying_doesNothing() {
        subject.setInput("oiewjre")
        subject.play()
        verify { fizzBuzz wasNot Called }
    }

    @Test
    fun whenPlaying_callsFizzBuzz() {
        every { fizzBuzz.play(any()) } returns "twelve"
        subject.setInput("12")
        subject.play()
        verify { fizzBuzz.play(12) }
        assertTrue(subject.showResult)
        assertEquals("The FizzBuzz of 12 is twelve.", subject.result)
    }

    @Test
    fun whenPlayingAnotherNumber_callsFizzBuzz() {
        every { fizzBuzz.play(any()) } returns "sven"
        subject.setInput("7")
        subject.play()
        verify { fizzBuzz.play(7) }
        assertTrue(subject.showResult)
        assertEquals("The FizzBuzz of 7 is sven.", subject.result)
    }

}