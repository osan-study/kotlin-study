data class Message (
    val sender: String,
    val text: String,
    val isRead: Boolean
)

data class Message2 (
    val sender: String,
    val text: String,
    val isRead: Boolean,
    val attachments: List<Attachment>
)

data class Attachment (
    val type: String,
    val name: String
)

fun Message2.isImportant(): Boolean =
    text.contains("Salary increase") || attachments.any { it.type == "image" && it.name.contains("cat") }

fun ignore(message: Message2) = !message.isImportant() && message.sender in setOf("Bob", "Sam")

data class Student(
    val id: Int,
    val name: String
)

class Frog
fun Frog.speak() = "HA!"

fun goFrog(frog: Frog, g: (Frog) -> String) = g(frog)

fun main() {
    val messages = listOf(
        Message("Sam", "hey!", true),
        Message("Sam", "where are you?", false)
    )
    val unread = messages.filterNot(Message::isRead)
    println("val unread = messages.filterNot(Message::isRead)")
    println("unread.size == 1: ${unread.size == 1}")
    println("unread.single().text == \"where are you?\": ${unread.single().text == "where are you?"}")

    val messages2 = listOf(
        Message("Sam", "hey!", true),
        Message("Sam", "where are you?", false),
        Message("Bob", "meeting today", false)
    )

    val sorted = listOf(
        Message("Bob", "meeting today", false),
        Message("Sam", "where are you?", false),
        Message("Sam", "hey!", true)
    )

    val sortedReverse = sorted.reversed()

    println("messages2.sortedWith(compareBy(Message::isRead, Message::sender)) == sorted: ${messages2.sortedWith(compareBy(Message::isRead, Message::sender)) == sorted}")

    println("messages2.sortedWith(compareBy(Message::isRead, Message::sender)) == sorted: ${messages2.sortedWith(compareBy(Message::isRead, Message::sender)) == sorted}")

    messages2.sortedWith (compareBy({it.isRead}, {it.sender})).asReversed()

    println("====================================")
    println(messages2.sortedWith(compareBy(Message::isRead, Message::sender)))
    println(messages2.sortedWith( { p1, p2 ->
        val com1 = p1.isRead.compareTo(p2.isRead)
        if (com1 == 0) {
            -p1.sender.compareTo(p2.sender)
        } else {
            -com1
        }
    }))
    println("==============================")

    val message3 = listOf(
        Message2("Bob", "let's discuss goals for next year", false, listOf(Attachment("image", "cute cats")))
    )

    println("message3.any(Message2::isImportant): ${message3.any(Message2::isImportant)}")

    val msgs = listOf(
        Message2("Bob", "let's discuss goals for next year", false, listOf()),
        Message2("Bob", "let's discuss goals for next year", false, listOf(Attachment("image", "cute cats")))
    )

    println("msgs.filter(::ignore).size == 1: ${msgs.filter(::ignore).size == 1}")
    println("msgs.filterNot(::ignore).size = 1: ${msgs.filterNot(::ignore).size == 1}")

    val names = listOf("Sam", "Bob")
    val students = names.mapIndexed { index, name -> Student(index, name)}
    val studentsList = listOf(
        Student(0, "Sam"),
        Student(1, "Bob")
        )
    println("students == studentsList: ${students == studentsList}")
    println("names.mapIndexed(::Student) == students: ${names.mapIndexed(::Student) == students}")

    println("goFrog(Frog(), Frog::speak) == \"HA!\": ${goFrog(Frog(), Frog::speak) == "HA!"}")
}