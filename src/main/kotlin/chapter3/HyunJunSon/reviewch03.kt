package chapter3.HyunJunSon

//
//fun String.doubleQuote() = "\"$this\""
//class Book(val title: String)
//fun Book.categorize(category: String) = """title: : "$title" , category: $category"""
//fun main() {
////    println("Test".doubleQuote())
//    println(Book("그리스인조르바").categorize("소설" +
//            ""))
//}

//fun main() {
//    val poem2 = """|->Lst night I saw upon the stair
//            |->A little man who wasn't there            |->He wasn't there again today            |->Oh, how I wish he'd go away."""
//    println(poem2.trimMargin(marginPrefix = "|->"))
//}

//class My{
//    fun foo() = 0}
//
//fun My.foo() = 1
////fun My.foo(i: Int) = i+2
//fun main() {
//    println(My().foo())
//}


//fun main() {
//    val dayOfWeek = 3
//    val dayName = when (dayOfWeek) {
//        1 -> "Sunday"
//        2 -> "Monday"
//        3 -> "Tuesday"
//        4 -> "Wednesday"
//        5 -> "Thursday"
//        6 -> "Friday"
//        7 -> "Saturday"
//        else -> "Invalid day"
//    }
//    println (dayName)  // 출력: Tuesday
//    // 표현식으로 사용할 때는 when의 결과를 변수에 저장하거나 반환합니다. 이 경우에는 모든 가능한 경우를 처리해야 하므로 else가 필요합니다.
//}


//fun bmiMetricWithWhen(
//    kg: Double, heightM: Double
//): String {
//    val bmi = kg / (heightM * heightM)
//    return when {
//        bmi < 18.5 -> "Underweight"
//        bmi < 25 -> "Normal weight"
//        else -> "Overweight"
//    }
//}
//
//fun main() {
//    println(bmiMetricWithWhen(72.57, 1.727))
//}

//enum class Direction(val notation: String) {
//    North("N"), South("S"), East("E"), West("W");  // 세미콜론이 꼭 필요하다
//
//    val opposite: Direction
//        get() = when (this) {
//            North -> South
//            South -> North
//            West -> East
//            East -> West
//        }
//}
//
//fun main() {
//    println(Direction.North.notation)  //N    println(Direction.North.opposite)  //South    println(Direction.North.opposite.opposite) //North    println(Direction.North.opposite.notation) //S}


//enum class Operation {
//    ADD {
//        override fun apply(x: Int, y: Int): Int = x + y
//    },
//    SUBTRACT {
//        override fun apply(x: Int, y: Int): Int = x - y
//    },
//    MULTIPLY {
//        override fun apply(x: Int, y: Int): Int = x * y
//    },
//    DIVIDE {
//        override fun apply(x: Int, y: Int): Int = x / y
//    };
//
//    // 추상 메소드 선언
//    abstract fun apply(x: Int, y: Int): Int
//}
//
//fun main() {
//    val x = 10
//    val y = 5
//    // 열거형 상수 사용
//    println("ADD: ${Operation.ADD.apply(x, y)}")          // 출력: ADD: 15
//    println("SUBTRACT: ${Operation.SUBTRACT.apply(x, y)}") // 출력: SUBTRACT: 5
//    println("MULTIPLY: ${Operation.MULTIPLY.apply(x, y)}") // 출력: MULTIPLY: 50
//    println("DIVIDE: ${Operation.DIVIDE.apply(x, y)}")     // 출력: DIVIDE: 2
//}

//data class Simple(
//    val arg1: String, var arg2: Int,
//)
//
//fun main() {
//    val s1 = Simple("Hi", 29)
//    val s1Copy = s1.copy()
//    println("Before modification:")
//    println ("s1: $s1")
//    println ("s1Copy: $s1Copy")
//    // s1의 값을 변경합니다.
//    s1.arg2 = 42
//    println("After modification:")
//    println ("s1: $s1")
//    println ("s1Copy: $s1Copy")
//}

//class Person(val name: String)
//
//data class Contact(
//    val name: String, val number: String,
//)
//
//fun main() {
//    println(Person("Cleo").equals(Person("Cleo")))  //false
//    println(
//        Contact("Cleo", "111-1111").equals(
//            Contact(
//                "Cleo",
//                "111-1111"
//            )
//        )
//    ) //true    println(Person("Cleo"))  //chapter3.HyunJunSon.Person@6bdf28bb    println(Contact("Cleo", "111-1111")) //Contact(name=Cleo, number=111-1111)    println(Person("Cleo").hashCode()) //920011586    println(Contact("Cleo", "111-1111").hashCode()) //1547457001
//}

//data class DetailContact(
//    val name: String, val surname: String, val number: String, val address: String,
//)
//
//fun main() {
//    val contact = DetailContact(
//        "Miffy", "Miller", "111-222", "우리집"
//    )
//    val newContact = contact.copy(
//        number = "222-333", address = "너희집"
//    )
//    val newContact2 = contact.copy()
//    println(contact) //DetailContact(name=Miffy, surname=Miller, number=111-222, address=우리집)
//    println(newContact)//DetailContact(name=Miffy, surname=Miller, number=222-333, address=너희집)
//    println(contact.equals(newContact2)) // true
//    println(contact === newContact2) // false
//}

//fun compute(input: Int): Pair<Int, String> =
//    if (input > 5) Pair(input * 2, "High") else Pair(input * 2, "Low")
//
//fun main() {
//    println(compute(7))
//    println (compute(4))
//    val result = compute(5)
//    println (result.first)
//    println (result.second)
//    val (value, decription) = compute(7)
//    println ("$value $decription");
//}


//fun main() {
//    var result = ""
//    val map = mapOf(1 to "one", 2 to "two")
//    for ((key, value) in map) {
//        result += "$key = $value "; }
//    println (result)
//    var res = ""
//    val listOfPairs =
//        listOf(Pair(1, "one"), Pair(2, "two"))
//    for ((i, s) in listOfPairs)
//        res += "($i, $s), "
//        println (res)
//    val li = listOf('a', 'b', 'c')
//    for ((idx, v) in li.withIndex())
//        println("$idx, $v")
//}

//fun main() {
//    val map = mapOf(0 to "yes", 1 to "no")
//    val first: String? = map[0]
//    val second: String? = map[1]
//    println (first)
//    println (second)
//}

//val String.indices: IntRange
//    get() = 0 until length
//
//fun main() {
//    println("abc".indices)
//}

//val List<*>.indices: IntRange
//    get() = 0 until size
//
//fun main() {
//    println(listOf(1).indices)  //0..0
//    println(listOf('a','b','c').indices) //0..2
//    println(emptyList<Int>().indices) //0..-1}
//}

//fun main() {
//    val list: List<*> = listOf(1,2,"ab", true)
//    val any: Any? = list[0]
//    val any2: Any = list[0] // 에러
//    val a: Int? = list[0] // 에러
//}


//fun main() {
//    outer@ for (i in 1..5) {
//        for (j in 1..5) {
//            if (i * j == 9) {
//                println("Breaking out of the outer loop at i = $i, j = $j")
//                break@outer // 레이블을 사용하여 바깥쪽 반복문 탈출
//            }
//            println("i = $i, j = $j")
//        }
//    }
//    println("Loop exited")
//}


fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    numbers.forEach {
        if (it == 3) {
            println("Returning at $it")
            return@forEach // 레이블을 사용하여 forEach의 현재 반복을 종료
        }
        println ("Current number: $it")
    }
    println ("Done with forEach")
}