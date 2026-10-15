package com.example.composetest

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CounterViewModel : ViewModel() {

    var currentNumber = MutableStateFlow(0)
        private set

    fun increment() {
        currentNumber.value += 1
    }

    fun decrement() {
        currentNumber.value -= 1
    }

    fun reset() {
        currentNumber.value = 0
    }

    fun onClick(btn: String): Int {

        when(btn) {
            "Up" -> {
                increment()
            }

            "Down" -> {
                decrement()
            }

            "Reset" -> {
                reset()
            }
        }

        return currentNumber.value
    }
}