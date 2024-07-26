package chapter5.moonggae

data class User(
    val id: Int,
    val name: String
) {
    companion object Com {
        private var count = 0
        fun createMock(): User = User(
            id = count++,
            name = "Mock User"
        )
    }

    fun increment() = ++count
}

fun main() {
    val mockUser = User.createMock()
    val mockUser2 = User.Com.createMock()

    println(mockUser)
    println(mockUser2)
    println(mockUser.increment())
    println(mockUser2.increment())
    println(mockUser.increment())
    println(mockUser2.increment())

    val mockUsr3 = User.createMock()
    println(mockUsr3)
}