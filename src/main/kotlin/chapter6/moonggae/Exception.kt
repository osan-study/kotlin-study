package chapter6.moonggae

open class InvalidUserIdException(
    message: String = "User id is invalid!"
) : Exception(message)

class TooLongUserIdException : InvalidUserIdException("User id is too long!")

sealed class UserIdValidateState(open val id: String) {
    data class Success(
        override val id: String
    ) : UserIdValidateState(id)

    data class Fail(
        override val id: String,
        val exception: InvalidUserIdException
    ) : UserIdValidateState(id)
}

fun validateUserId(id: String): UserIdValidateState {
    var state: UserIdValidateState
    try {
        if (id.length > 10) throw TooLongUserIdException()
        if (id.isBlank()) throw InvalidUserIdException()
        state = UserIdValidateState.Success(id)
    } catch (e: InvalidUserIdException) {
        println("InvalidUserIdException")
        state = UserIdValidateState.Fail(id + "123", e)
    } catch (e: TooLongUserIdException) {
        println("TooLongUserIdException")
        state = UserIdValidateState.Fail(id, e)
    } finally {
        println("UserId validation attempted for id: $id")
    }

    return state
}

fun main() {
    val userIdState = validateUserId("aegreaergerghreg")
    println(userIdState)
}
