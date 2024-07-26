package chapter5.moonggae

class PrivateUser private constructor(
    val id: Int,
    val name: String
) {
    companion object Factory {
        private var count: Int = 0
        fun create(name: String): PrivateUser = PrivateUser(
            id = count++,
            name = name
        )
    }

    override fun toString(): String = "[PrivateUser(id:$id, name:$name)]"
}

fun main() {
    val users = List(10) { PrivateUser.create("User $it") }
    println(users)
}