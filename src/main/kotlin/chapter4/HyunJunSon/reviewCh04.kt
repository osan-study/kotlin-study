package chapter4.HyunJunSon

import kotlin.random.Random

//fun main() {
//    val list = listOf('a','b','c').mapIndexed{idx, elem-> "[$idx, $elem]"}    //[[0, a], [1, b], [2, c]]    println(list)    val list2 = listOf('a', 'b', 'c').mapIndexed{ idx, _ -> "[$idx]" } //[[0], [1], [2]]\    println(list2)    val list3 = listOf('a', 'b', 'c').indices.map{"[$it]"} //[[0], [1], [2]]    println(list3)        listOf('a','b','c').indices // 0..2(IntRange객체)
//
//    run{        -> println("A Lamda")   // 이렇게도 쓸수 있지만, 매개변수가 없으면 -> 를 쓰지 않는 것을 권장한다.
//    }
//    run{        println("Without args") // 매개변수가 없는 경우
//    }
//}

//fun main() {
//    val divider = 5
//    val list = listOf(1, 5, 7, 19).filter { it % divider == 0 } // 자바는 final, effective final만 가능. 코틀린은 값이 변경되어도 참조 가능
//    println(list)
//    var sum = 0
//    listOf (1, 5, 7, 10).filter { it % 5 == 0 }.forEach { sum += it }
//    println (sum)
//    val sum2 = listOf(1, 5, 7, 10).filter { it % 5 == 0 }.sum()
//    println (sum2)
//}

//fun main() {
//    val list1 = List(10){it}   //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]  // idx가 전달되는 람다
////    val list2 = List(10){0}  //[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
////     val list3 = List(10){'a'+it} //[a, b, c, d, e, f, g, h, i, j] //    val list7 = List(10){"a"+it} //["a0" ,"a1", "a2"]
////    val list4 = List(10){list3[it%3]} //[a, b, c, a, b, c, a, b, c, a]
////
////    //mutable
////     val list5 = MutableList(5,{10* (it+1)})  //[10, 20, 30, 40, 50]
////     val list6 = MutableList(5){10* (it+1)}  //[10, 20, 30, 40, 50]
//////
////    println(list5)
////    println(list6)
//    val listK = List(1){it}
//    val resList8 = listK.single()
//    println(resList8)

//}

//data class Product(
//    val description: String,    val price: Double)
//
//fun main() {
//    val products = listOf(        Product("bread", 2.0),        Product("wine", 5.0),    )
//    val sum1 = products.sumOf { it.price } //7.0    val obj = products.sortedByDescending { it.price }    //[Product(description=wine, price=5.0), Product(description=bread, price=2.0)]
//
//    val obj22 = products.sortedBy { it.price }    //[Product(description=bread, price=2.0), Product(description=wine, price=5.0)]
//    val obj2 = products.minByOrNull{it.price}//    Product(description=bread, price=2.0)
//
//
//    val take = products.take(2) //[Product(description=bread, price=2.0), Product(description=wine, price=5.0)]    val takeLast = products.takeLast(1); //[Product(description=wine, price=5.0)] (뒤에서 한개)
//
//    val drop = products.drop(1) // 원본 그대로있음 [Product(description=wine, price=5.0)]
//     val charList = List(5){'a'+ it}
//     val takeLastWhile = charList.takeLastWhile { it > 'b' } // [c, d, e]
//    println(takeLastWhile)}
//

//fun Int.times47() = times(47)
//fun Int.times2() = times(2)
//
//class Frog
//fun Frog.speak() = "Ribbit!"
//
//fun goInt(n: Int, g: (Int) -> Int) = g(n)
//fun goFrog(frog: Frog, g: (Frog) -> String) = g(frog)
//
//fun main() {
//    println(goInt(12, Int::times47))
//    println(goFrog(Frog(),Frog::speak))}

//fun main() {
//    repeat(4) {idx ->println("$idx")}}

//
//data class Person(
//    val name: String,
//    val id: Int
//) {
//    constructor(pair: Pair<String, Int>) : this(pair.first, pair.second)
//}
//
//fun main() {
//    val names = listOf("Bob", "Jill", "Jim")
//    val ids = listOf(1731, 9274, 8378)
//
//    // zip을 통해 Pair 리스트 생성
//    val pairs = names.zip(ids)
//
//    // map을 사용하여 생성자 참조
//    val people = pairs.map(::Person)
//
//    println(people)
//}


//enum class Suit {
//    Spade, Club, Heart, Diamond}
//
//enum class Rank(val faceValue: Int) {
//    Ace(1), Two(2), Three(3), Four(4), Five(5),    Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10),    Queen(10), King(10)}
//
//class Card(val rank: Rank, val suit: Suit) {
//    override fun toString(): String {        return "$rank of ${suit}s"    }}
//
//val deck: List<Card> =
//    Suit.values().flatMap { suit ->        Rank.values().map { rank ->            Card(rank, suit)        }    }
//fun main() {
//    val rand = Random(26)
//    repeat(7) {        println(deck.random(rand))    }
//}
//data class Person(
//    val name: String,    val age: Int)
//
//val names = listOf("Alice","Arthricia","Bob","Bill","Birdperson","Charlie","Crocubot","Franz","Revolio")
//val ages = listOf(21,15,25,25,42,21,42,21,33)
//
//fun main() {
//    val associateWith = person().associateWith { it.name }
////    {Person(name=Alice, age=21)=Alice, Person(name=Arthricia, age=15)=Arthricia, Person(name=Bob, age=25)=Bob, Person(name=Bill, age=25)=Bill, Person(name=Birdperson, age=42)=Birdperson, Person(name=Charlie, age=21)=Charlie, Person(name=Crocubot, age=42)=Crocubot, Person(name=Franz, age=21)=Franz, Person(name=Revolio, age=33)=Revolio}
//    val associateBy = person().associateBy { it.age }
////{21=Person(name=Franz, age=21), 15=Person(name=Arthricia, age=15), 25=Person(name=Bill, age=25), 42=Person(name=Crocubot, age=42), 33=Person(name=Revolio, age=33)}
//}
//fun person() : List<Person> =
//    names.zip(ages).map{(name,age) -> Person(name,age)}

//
//fun main() {
//    val even = mapOf(2 to "two", 4 to "four")
//    val map = even.map { "${it.key} = ${it.value}" } //[2 = two, 4 = four]
//    val mapKeys =
//        even.mapKeys { (num, _) -> -num }  // {-2=two, -4=four}    val newMap = even.mapKeys { (num, value) ->        // 값(value)을 변경해도 원본 맵에 영향을 미치지 않음 (대문자로 안바낌)
////    val newValue = value.uppercase() - num
//
////    println(newMap) // {-2=two, -4=four}    println(even)   // {2=two, 4=four}
//
//
//    val mapValues = mapKeys.mapValues { (_, str) -> "minus $str" } // {-2=minus two, -4=minus four}
//    println(mapValues)
//    val map1 =
//        even.map { (key, value) -> -key to "minus $value" }  // [(-2, minus two), (-4, minus four)]    val toMap = map1.toMap() // {-2=minus two, -4=minus four}
//    println(map1)
////    println(toMap)
//    val any = even.any { (key, _) -> key < 0 }
//    val all = even.all { (key, _) -> key > 0 }
//    val value = even.maxByOrNull { it.key }?.value//    println(all)
////    println(value)
//}
//
//fun main() {
//    val items = mutableListOf("first", "second", "third", "XXX", "4th")
////    println(items.removeAt(0)) // "first"
//    val seq = generateSequence {        items.removeAt(0).takeIf { it != "XXX" }    }  // kotlin.sequences.ConstrainedOnceSequence@4f3f5b24
////    println(seq.toList())
////    println(seq.toList()) // 두번 사용 안된다.
////    Exception in thread "main" java.lang.IllegalStateException: This sequence can be consumed only once.
////      at kotlin.sequences.ConstrainedOnceSequence.iterator(SequencesJVM.kt:23)
////      at kotlin.sequences.SequencesKt___SequencesKt.toList(_Sequences.kt:812)
////      at chapter4.HyunJunSon.Ch04Kt.main(ch04.kt:530)
////      at chapter4.HyunJunSon.Ch04Kt.main(ch04.kt)
//
//}


fun main() {
    val list = listOf(1,2,3,4,5)
    val value = 3
    var result = ""
    list.forEach tag@{
        result += "$it"
        if (it == value) return@tag
        println("test")
    }
    println(result) //12345
 }