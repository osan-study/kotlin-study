package chapter5.moonggae

import chapter1.moonggae.util.runExample
import kotlin.random.Random

abstract class AbstractUiState {
    abstract val state: String
}

class AbstractSuccess(
    override val state: String = "AbstractSuccess"
): AbstractUiState() {
    val data: String = "User Data"
}

class AbstractLoading(
    override val state: String = "AbstractLoading"
): AbstractUiState() {
    val duration: Int = 1000
}

class AbstractFail(
    override val state: String = "AbstractFail"
): AbstractUiState() {
    val exception: String = "Unknown Exception"
}

enum class EnumUiState(
    val stateString: String
) {
    SUCCESS("EnumSuccess"),
    LOADING("EnumLoading"),
    FAIL("EnumFail")
}

sealed class SealedUiState(
    val state: String
) {
    data class Success(val data: String): SealedUiState("success")
    data object Loading: SealedUiState("Loading")
    data class Fail(val exception: String): SealedUiState("Fail")
}

fun runAbstractState() {
    fun getRandomAbstractState(): AbstractUiState = when (Random.nextInt(3)) {
        0 -> AbstractSuccess()
        1 -> AbstractLoading()
        2 -> AbstractFail()
        else -> AbstractFail()
    }

    val state: String? = when (val abstractUiState = getRandomAbstractState()) {
        is AbstractSuccess -> abstractUiState.data
        is AbstractLoading -> "${abstractUiState.duration}"
        is AbstractFail -> abstractUiState.exception
        else -> null
    }

    println(state)
}

fun runEnumState() {
    fun getRandomEnumState(): EnumUiState = when (Random.nextInt(3)) {
        0 -> EnumUiState.SUCCESS
        1 -> EnumUiState.LOADING
        2 -> EnumUiState.FAIL
        else -> EnumUiState.FAIL
    }

    val state = when (val enumState = getRandomEnumState()) {
        EnumUiState.SUCCESS -> enumState.stateString
        EnumUiState.LOADING -> enumState.stateString
        EnumUiState.FAIL -> enumState.stateString
    }

    println(state)
}


fun runSealedState() {
    fun getRandomSealedState(): SealedUiState = when (Random.nextInt(3)) {
        0 -> SealedUiState.Success("User Data")
        1 -> SealedUiState.Loading
        2 -> SealedUiState.Fail("UnknownException")
        else -> SealedUiState.Fail("UnknownException")
    }

    val printState: String = when (val state = getRandomSealedState()) {
        is SealedUiState.Success -> state.data
        is SealedUiState.Loading -> "loading"
        is SealedUiState.Fail -> state.exception
    }

    println(printState)
}

sealed class Top
class Middle1: Top()
class Middle2: Top()
open class Middle3: Top()
class Bottom3: Middle3()

fun sealedSubclass() {
    val names = Top::class.sealedSubclasses.map { it.simpleName }
    println(names)
}


fun main() {
    runExample(::runAbstractState)
    runExample(::runEnumState)
    runExample(::runSealedState)
    runExample(::sealedSubclass)
}