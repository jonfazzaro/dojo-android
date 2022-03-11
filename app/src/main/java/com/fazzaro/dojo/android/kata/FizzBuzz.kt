package com.fazzaro.dojo.android.kata

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FizzBuzz {
    suspend fun play(input: Int): String = suspendCoroutine {
        it.resume("Birds aren't real")
    }

}
