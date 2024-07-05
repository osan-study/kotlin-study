package chapter3.HyunJunSon

//fun main() {
//    fun String.singleQuote() = "'$this'"
//    println("hello".singleQuote().singleQuote())
//
//    fun String.doubleQuote() = "\"$this\""
//    println("Test".doubleQuote())
//
//    fun String.tooManyQuotes() = doubleQuote().doubleQuote()
//    println("Hi".tooManyQuotes())
//
//}

//class Book(val title: String)
//
//fun Book.categorize(category: String) = """title: : "$title" , category: $category"""
//fun main() {
//   println(Book("바람과 함께 사라지다").categorize("소설"))
//}

//fun main() {
//    val list = listOf(1,2,3)
//    println(list.toString())
//    println(list.joinToString("+"))
//    println(list.joinToString(prefix = "(", postfix = ")"))
//}


//class DefaultArg
//val da = DefaultArg()
//
//fun g(d: DefaultArg = da) = println(d)
//
//fun h(d: DefaultArg = DefaultArg()) = println(d)
//
//fun main() {
//    g()
//    g()
//    h()
//    h()
//}


//fun main() {
//    val poem = """
//        |->Lst night I saw upon the stair
//            |->A little man who wasn't there
//                |->He wasn't there again today
//                    |->Oh, how I wish he'd go away."""
//
//    println(poem.trimMargin())
//
//
//    val poem2 = """|->Lst night I saw upon the stair
//            |->A little man who wasn't there
//            |->He wasn't there again today
//            |->Oh, how I wish he'd go away."""
//
//    println(poem2.trimMargin(marginPrefix = "|->"))
//}

//class My{
//    fun foo() = 0
//}
//
//fun My.foo() = 1
//fun My.foo(i: Int) = i+2
//fun main() {
//    println(My().foo())
//    println(My().foo(1))
//}


//fun foo(n: Int = 99) = println("foo-1-$n")
//fun foo(){
//    println("foo-2")
//    foo(14)
//}
//
//fun main() {
//    foo()
//}


//fun main() {
//    val dayOfWeek = 2
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
//    println(dayName)  // 출력: Tuesday
//}

//fun main() {
//    val number = 2
//
//    when (number) {
//        1 -> println("One")
//        2 -> println("Two")
//        3 -> println("Three")
//        // 'else'가 없어도 컴파일 오류가 발생하지 않습니다.
//    }
//}

//fun main() {
//    println(setOf("red","blue") == setOf("blue", "red")) // false
//}

//fun mixColors(first:String, second:String) =
//    when (setOf(first, second)){
//        setOf("red","blue") -> "purple"
//        setOf("red","yellow") -> "orange"
//        setOf("blue","yellow") -> "green"
//        else -> "unknown"
//    }
//
//fun main() {
//    println(mixColors("red","blue"))
//}


//fun bmiMetricWithWhen(
//    kg: Double,
//    heightM: Double
//): String{
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
//
//import chapter3.HyunJunSon.enumerations.Level
//import chapter3.HyunJunSon.enumerations.Size
//
//fun main() {
//    println(Level.Overflow)
//    println(Size.Gigantic)
//    println(Size.values().toList())
//    println(Size.Tiny.ordinal)
//}

//
//enum class Direction(val notation: String){
//    North("N"), South("S"), East("E"), West("W");  // 세미콜론이 꼭 필요하다
//    val opposite: Direction
//        get() = when (this){
//            North -> South
//            South -> North
//            West -> East
//            East -> West
//        }
//}
//
//fun main() {
//    println(Direction.North.notation)
//    println(Direction.North.opposite)
//    println(Direction.North.opposite.opposite)
//    println(Direction.North.opposite.notation)
//}


//data class Simple(
//    val arg1: String,
//    var arg2: Int,
//)
//
//fun main() {
//    val s1 = Simple("Hi", 29);
//    val s2 = Simple("Hi", 29);
//
//    println(s1.equals(s2))
//    println(s1.hashCode())
//    println(s1.copy().hashCode())
//    println(s1.hashCode())
//}

//class Person(val name: String)
//
//data class Contact(
//    val name: String,
//    val number: String,
//)
//
//fun main() {
//    println(Person("Cleo").equals(Person("Cleo")))
//    println(Contact("Cleo", "111-1111").equals(Contact("Cleo","111-1111")))
//    println(Person("Cleo"))
//    println(Contact("Cleo", "111-1111"))
//    println(Person("Cleo").hashCode())
//    println(Contact("Cleo", "111-1111").hashCode())
//}


//data class DetailContact(
//    val name: String,
//    val surname: String,
//    val number: String,
//    val address: String,
//)
//
//fun main() {
//    val contact = DetailContact(
//        "Miffy",
//        "Miller",
//        "111-222",
//        "우리집"
//    )
//    val newContact = contact.copy(
//        number = "222-333",
//        address = "너희집"
//    )
//    val newContact2 = contact.copy()
//
//    println(contact) // DetailContact(name=Miffy, surname=Miller, number=111-222, address=우리집)
//    println(newContact) // DetailContact(name=Miffy, surname=Miller, number=222-333, address=너희집)
//    println(contact.equals(newContact2)) // true
//    println(contact === newContact2)
//}


//구조분해선언
//
//fun compute(input: Int): Pair<Int, String> =
//    if (input > 5)
//        Pair(input *2, "High")
//    else
//        Pair(input *2 , "Low")
//
//fun main() {
//    println(compute(7))
//    println(compute(4))
//    val result = compute(5)
//    println(result.first)
//    println(result.second)
//
//    val (value, decription) = compute(7)
//    println("$value $decription");
//}

//
//data class Tuple(
//    val i : Int,
//    val d : Double,
//    val s : String,
//    val b : Boolean,
//    val l : List<Int>
//)
//
//fun main() {
//    val tuple = Tuple(1, 10.2, "HI",true,listOf(1,2,3))
//    val (a,b,c,d,e) = tuple
//    println("$a $b $c $d $e")
//    val (_,_,hello) = tuple
//    println(hello)
//}

//fun main() {
//    var result = ""
//    val map = mapOf(1 to "one", 2 to "two")
//    for ((key, value) in map){
//        result += "$key = $value ";
//    }
//    println(result)
//
//    var res = ""
//    val listOfPairs = listOf(Pair(1,"one"), Pair(2,"two"))
//    for ((i,s) in listOfPairs)
//        res += "($i, $s), "
//
//    println(res)
//
//    val li = listOf('a','b','c')
//    for ((idx, v) in li.withIndex())
//        println("$idx, $v")
//}

//fun main() {
//    val s1 = null
////    val s2:String = null  // 컴파일오류
//
//    val s3 :String? = null
//    val s4 :String? = s1
//
////    val s5 :String  = s4 // 컴파일오류
//    val s6 = s4
//    println(s1)
//    println(s3)
//    println(s4)
//    println(s6)
//
//}

//fun main() {
//    val map = mapOf(0 to "yes", 1 to "no")
//    val first :String? = map[0]
//    val second: String? = map[1]
//    println(first)
//    println(second)
//}

//fun main() {
//    val s1: String = "abc"
//    val s2: String? = s1
//
//    println(s1.length)
//    println(s2?.length)
////    println(s2.length) // 에러발생
//}

//fun String.echo() = {
//    println(this.uppercase())
//    println(this)
//    println(this.lowercase())
//}
//
//fun main() {
//    val s1: String? = "Howdy!"
//    s1?.echo()
//    val s2: String? = null
//    s2?.echo()
//}

// String의 확장 함수로 정의
//fun String.echo() {
//    println(uppercase())
//    println(this)
//    println(lowercase())
//}
//
//fun main() {
//    val s1: String? = "Howdy!"
//    s1?.echo() // s1이 null이 아니므로 함수 호출
//    val s2: String? = null
//    s2?.echo() // s2가 null이므로 함수 호출되지 않음
//}


//fun checkLength(s: String?) : Int{
//    return s?.length ?: -999
//}
//
//fun main() {
//    println(checkLength(""))
//}

//
//class Person(
//    val name: String,
//    var friend: Person? = null
//)
//
//fun main() {
//    val alice = Person("Alice")
//    println(alice.friend?.friend?.name)
//    val bob = Person("Bob")
//    val charlie = Person("Charlie", bob)
//    bob.friend = charlie
//    println(bob.friend?.friend?.name)
//    println(alice.friend?.friend?.name ?: "Unknown")
//}

//fun main() {
//    var x: String? = "abc"
//    println(x!!)
//    x = null
//    val s: String = x!!
//    println(s)
//}

//fun main() {
//    val s: String? = "abc"
//    println(s!!.length)
//}


//fun main() {
//    val s1: String? = null
//    println(s1.isNullOrEmpty())
//    println(s1.isNullOrBlank())
//
//    val s2 = ""
//    println(s2.isNullOrEmpty())
//    println(s2.isNullOrBlank())
//
//    val s3 = " \t\n"
//    println(s3.isNullOrEmpty())
//    println(s3.isNullOrBlank())
//}

//class AnyHolder(private val value: Any){
//    fun getValue() = value
//}
//
//class Dog{
//    fun bark() = "Ruff!"
//}
//class GenericHolder<T>(
//    private val value: T
//) {
//    fun getValue() :T = value
//}
//
//fun main() {
//    val holder = AnyHolder(Dog())
//    val any = holder.getValue()  // any.bark() 컴파일오류
//
//    val genericHolder = GenericHolder(Dog())
//    val dog = genericHolder.getValue()
//    println(dog.bark())
//
//}
//
//fun <T> identity(arg: T) :T = arg
//class Dog{
//    fun bark() = "왈왈"
//}
//fun main() {
//    println(identity("Yello"))
//    println(identity(1))
//    val d:Dog = identity(Dog())
//    println(identity(d.bark()))
//}

//
//val String.indices : IntRange
//    get() = 0 until length
//fun main() {
//    println("abc".indices)
//}

//fun main() {
//    println(listOf(1,2,3).firstOrNull())
//}

//val List<*>.indices: IntRange
//    get() = 0 until size
//
//fun main() {
//    println(listOf(1).indices)  //0..0
//    println(listOf('a','b','c').indices) //0..2
//    println(emptyList<Int>().indices) //0..-1
//}

//fun main() {
//    val list: List<*> = listOf(1,2,"ab", true)
//    val any: Any? = list[0]
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

//fun main() {
//    val numbers = listOf(1, 2, 3, 4, 5)
//
//    numbers.forEach {
//        if (it == 3) {
//            println("Returning at $it")
//            return@forEach // 레이블을 사용하여 forEach의 현재 반복을 종료
//        }
//        println("Current number: $it")
//    }
//    println("Done with forEach")
//}


data class Tuple(
    val i : Int,
    val d : Double,
    val s : String,
    val b : Boolean,
    val l : List<Int>
)

fun main() {
    val tuple = Tuple(1, 10.2, "HI",true,listOf(1,2,3))
    val (a,b,c,d,e) = tuple
    println("$a $b $c $d $e")
    val (_,_,hello) = tuple
    println(hello)
}