package chapter5.moonggae

import chapter1.moonggae.util.runExample
import kotlin.random.Random

interface UiState {
    fun printState()
}

class Success(
    val data: String
): UiState {
    override fun printState() {
        println("Success")
    }
}

class Loading(
    val duration: Int
): UiState {
    override fun printState() {
        println("Loading")
    }
}

class Fail(
    val exception: String
): UiState {
    override fun printState() {
        println("Fail")
    }
}

fun getRandomState(): UiState =
    when (Random.nextInt(3)) {
        0 -> Success("User Data")
        1 -> Loading(1000)
        else -> Fail("Unknown Exception")
    }


fun runSmartCasting() {
    val currentState = getRandomState()

    if (currentState is Success)
        currentState.printState()

    when (currentState) {
        is Success -> println(currentState.data)
        is Loading -> println(currentState.duration)
        is Fail -> println(currentState.exception)
    }
}

fun runMutableReferences() {
    var immutableState: UiState = Loading(10)
    immutableState = getRandomState()
    when (val mutableState = immutableState) {
        is Success -> println(mutableState.data)
        is Loading -> println(mutableState.duration)
        is Fail -> println(mutableState.exception)
    }
}

fun unsafe() {
    val state = getRandomState()
    val currentState: UiState? = (state as? Success)

    when (currentState) {
        null -> println("null")
        else -> currentState.printState()
    }
}

fun filter() {
    val states = List(10) { getRandomState() }
    states.filterIsInstance<Success>().forEach {
        println(it.data)
    }
}


fun main() {
    runExample(::runSmartCasting)
    runExample(::runMutableReferences)
    runExample(::unsafe)
    runExample(::filter)
}