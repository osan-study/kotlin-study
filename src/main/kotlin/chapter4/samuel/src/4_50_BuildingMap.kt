data class Person2 (
    val name: String,
    val age: Int
)

val names = listOf("Sam", "Bob", "Jane")
val ages = listOf(30, 30, 28)

fun people(): List<Person2> = names.zip(ages) { name, age -> Person2(name, age) }

fun main() {
    println("names.zip(ages) { name, age -> Person2(name, age) }.toString() == \"[Person2(name=Sam, age=30), Person2(name=Bob, age=30), Person2(name=Jane, age=28)]\": ${names.zip(ages) { name, age -> Person2(name, age) }.toString() == "[Person2(name=Sam, age=30), Person2(name=Bob, age=30), Person2(name=Jane, age=28)]"}")

    val map: Map<Int, List<Person2>> = people().groupBy(Person2::age)

    println("map[30] == listOf(Person2(\"Sam\", 30), Person2(\"Bob\", 30)): ${map[30] == listOf(Person2("Sam", 30), Person2("Bob", 30))}")
    println("map[28] == listOf(Person2(\"Jane\", 28)): ${map[28] == listOf(Person2("Jane", 28))}")
    println("map[20] == null: ${map[20] == null}")
    
    println("people().partition { it.name.first() == 'S' }.toString() == \"([Person2(name=Sam, age=30)], [Person2(name=Bob, age=30), Person2(name=Jane, age=28)])\": ${people().partition { it.name.first() == 'S' }.toString() == "([Person2(name=Sam, age=30)], [Person2(name=Bob, age=30), Person2(name=Jane, age=28)])"}")

    val mapAssociateWith: Map<Person2, String> = people().associateWith { it.name }
    val mapAssociateBy: Map<String, Person2> = people().associateBy { it.name }

    println("mapAssociateWith: $mapAssociateWith")
    println("mapAssociateBy: $mapAssociateBy")

    val map2 = mapOf(1 to "one", 2 to "two")
    println("map.getOrElse(0) { \"zero\" } == \"zero\": ${map.getOrElse(0) { "zero" } == "zero"}")

    val mutableMap = map2.toMutableMap()
    println("mutableMap.getOrPut(0) { \"zero\" } == \"zero\": ${mutableMap.getOrPut(0) { "zero" } == "zero"}")
    println("mutableMap.toString() == \"{1=one, 2=two, 0=zero}\": ${mutableMap.toString() == "{1=one, 2=two, 0=zero}"}")

    val map3 = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")

    println("map3.filterKeys { it % 2 == 1 }: ${map3.filterKeys { it % 2 == 1 }}")
    println("map3.filterValues { it.contains('o') }: ${map3.filterValues { it.contains('o') }}")
    println("map3.filter { entry -> entry.key % 2 == 1 && entry.value.contains('o') }: ${map3.filter { entry -> entry.key % 2 == 1 && entry.value.contains('o') }}")

    val map4 = mapOf(2 to "two", 4 to "four")
    println(map4.map { "${it.key}: ${it.value}" })
    println(map4.mapKeys { (num, _) -> -num }. mapValues{ (_, str) -> "minus $str"})
    println(map4.map {(key, value) -> -key to "minus $value"}.toMap())

}