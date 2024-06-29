package chapter3.moonggae

enum class Response(val code: Int) {
    CONFLICT_ID(1),
    INVALID_ID(2),
    INVALID_PASSWORD(3),

    NOT_FOUND_USER(10),
    WRONG_PASSWORD(11),

    LOGGED_IN(200),
    SIGNED_UP(201),

    BAD_REQUEST(400),
    SERVER_ERROR(500)
}

class Server {
    private val users: MutableMap<String, String> = mutableMapOf()

    private fun isExistsId(id: String): Boolean {
        return users.containsKey(id)
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 6 // 비밀번호는 최소 6자리
    }

    private fun isValidId(id: String): Boolean {
        return id.matches(Regex("^[a-zA-Z0-9_]+$")) // ID는 알파벳, 숫자, 밑줄(_)만 포함
    }

    private fun isSqlInjection(input: String): Boolean {
        val sqlInjectionPatterns = listOf(
            ".*(['\";]+|(--)+).*".toRegex(),  // 기본적인 SQL Injection 패턴
            ".*((SELECT|INSERT|UPDATE|DELETE|DROP|ALTER|EXEC|UNION|--|;)+).*".toRegex(RegexOption.IGNORE_CASE)  // SQL 명령어 패턴
        )
        return sqlInjectionPatterns.any { it.matches(input) }
    }

    fun signUp(id: String, password: String): Response = when {
        isSqlInjection(id) || isSqlInjection(password) -> Response.BAD_REQUEST
        !isValidId(id) -> Response.INVALID_ID
        !isValidPassword(password) -> Response.INVALID_PASSWORD
        isExistsId(id) -> Response.CONFLICT_ID
        else -> {
            users[id] = password
            Response.SIGNED_UP
        }
    }

    fun login(id: String, password: String): Response = when {
        isSqlInjection(id) || isSqlInjection(password) -> Response.BAD_REQUEST
        !isExistsId(id) -> Response.NOT_FOUND_USER
        users[id] != password -> Response.WRONG_PASSWORD
        else -> Response.LOGGED_IN
    }
}

fun main() {
    val server = Server()
    println(server.signUp("validUser1", "pass123")) // SIGNED_UP
    println(server.signUp("invalidUser#", "pass123")) // INVALID_ID
    println(server.signUp("validUser2", "123")) // INVALID_PASSWORD
    println(server.signUp("validUser1", "pass123")) // CONFLICT_ID

    println(server.signUp("validUser3", "pass123'; DROP TABLE users; --")) // BAD_REQUEST
    println(server.signUp("validUser4", "pass123")) // SIGNED_UP

    println(server.login("validUser1", "pass123")) // LOGGED_IN
    println(server.login("validUser2", "pass123")) // NOT_FOUND_USER
    println(server.login("validUser1", "wrongpass")) // WRONG_PASSWORD
    println(server.login("validUser4", "pass123'; DROP TABLE users; --")) // BAD_REQUEST
}