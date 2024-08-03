//package chapter2.HyunJunSon
//
//fun main() {
//
//    println(inferred('a','b'))
//    println(explict('k','t'))
//
//}
//
//fun inferred(p: Char, q: Char) = listOf(p,q)
//fun explict(p:Char, q:Char) :List<Char> = listOf(p,q)

//fun main() {
//    val list1 = mutableListOf('A')
//    list1 += 'A'
//    list1.plusAssign('A')  // 가변객체에 값이 한나씩 추가 ['A','A','A']
//
////    val list2 = listOf('B')
////    list += 'B' // 에러
//
//
//    var list3 = listOf('C')
//    list3 += 'C'   // ['C' ,'C] 인 새로운 객체 만들어서 list3 삽입
//    val newList = list3 + 'C'
//    println(list3 == newList) // false
//
//
//}

//fun printNumbers(vararg numbers: Int) {
//    for (number in numbers) {
//        println(number)
//    }
//}

//fun main() {
////    val list = listOf(1, 2, 3, 4)
////    val intArray = list.toIntArray() // Convert List to IntArray
////    printNumbers(*intArray) // Using spread operator with IntArray
//////    printNumbers(*list)  // 에러 발생
//}

//fun main() {
//    val list = listOf(3,3,2,1,2) // 불변
//    val list2 = mutableSetOf(1,2,1,2,3) // 가변
//
//    list.toSet()
//    list.distinct()
//    "aabbcc".toSet()  //['a','b','c'] 중복을 제거한 char 타입요소 set반환
//
//    list.contains(2)  // true
//    list.containsAll(setOf(1,2,9)) // false
//    list.union(setOf(3,4)) // [1,2,3,4]
//    list.intersect(setOf(0,1,2,7,8)) // [2]
//    list.subtract(setOf(1)) // [2,3]
//    list - setOf(2,3) // [1]
//
//}

//fun main() {
//    val constants = mapOf(  // {Pi=3.14, e=2.718, phi=1.618}
//        "Pi" to 3.14,
//        "e" to 2.718,
//        "phi" to 1.618
//    )
//
//    println(constants.getOrDefault("P",5))
//
//}

//data class Student2(
//    var name: String,
//    val age: Int
//) {
//    var nickname: String = name
//        get() {
//            println("Getting nickname")
//            return field
//        }
//        set(value) {
//            println("Setting nickname to $value")
//            field = value
//        }
//}

//fun main() {
//    val son = Student2("son", 30)
////    println(son.name) // son
////    son.name = "hi"
////    println(son.name) // hi
////    println(son.age)  // 30
//
//    // 커스터마이즈된 getter와 setter 사용
//    println(son.nickname) // Getting nickname \n son
//    son.nickname = "sonny" // Setting nickname to sonny
//    println(son.nickname) // Getting nickname \n sonny
//}


//class Counter3 {
//    var value: Int = 0
//        private set
//
//    fun inc() = value++
//}
//fun main() {
//    val counter = Counter3()
//    repeat(10) {
//        counter.inc()
//    }
////    counter.value++
//    println(counter.value)
//}


//fun String.echo() {
//    println(this.uppercase())
//    println(this)
//    println(this.lowercase())}

//fun main() {
//    val s1: String? = "Howdy!"
//    s1?.echo () // s1이 null이 아니므로 함수 호출
//    val s2: String? = null
//    s2?.echo () // s2가 null이므로 함수 호출되지 않음
//}

//fun checkLength(s: String?) : Int{
//    return s?.length ?: -999}
//
//fun main() {
//    println(checkLength(""))}


fun main() {
    val s1: String? = null
    println (s1.isNullOrEmpty())
    println (s1.isNullOrBlank())
    val s2 = ""
    println (s2.isNullOrEmpty())
    println (s2.isNullOrBlank())
    val s3 = " \t\n"
    println (s3.isNullOrEmpty())
    println (s3.isNullOrBlank())
}