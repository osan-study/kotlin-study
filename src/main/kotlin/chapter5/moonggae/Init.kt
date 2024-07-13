package chapter5.moonggae

var peopleCount = 0

class Person(val fullName: String) {
//    val firstName: String = fullName.split(" ")[1]
    val firstName: String
    val lastName: String


//    lateinit var nameSize: Int // 'lateinit' modifier is not allowed on properties of primitive types

    init {
        println("init1")
    }

    init {
        println("init2")
        firstName = fullName.split(" ")[1]
        lastName = fullName.split(" ")[0]
        peopleCount += 1
    }
}


fun main() {
    val peoples = listOf(
        Person("신 짱구"),
        Person("이 훈이"),
        Person("김 철수")
    )

    peoples.forEach { println(it.firstName) }

    println("peopleCount: $peopleCount")
}