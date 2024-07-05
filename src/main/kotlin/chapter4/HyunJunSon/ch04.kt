package chapter4.HyunJunSon

import kotlin.random.Random
import kotlin.text.Typography.times

//fun main() {
//    val result = listOf(1,2,3,4).map{it*2}
//    println(result)
//    var res = listOf('a','b','c','d').map({it.uppercase()})
//    println(res)
//    var res2 = listOf('a', 'b', 'c', 'd').map{ it.uppercase() }
//    println(res2)
//
//    var res3 = listOf(9,11,23,32).joinToString(""){"[$it]"} // seperator default = ','
//    val res33 = listOf(9, 11, 23, 32).map { "[$it]" }.joinToString("")
//    var res333 = listOf(9,11,23,32).joinToString("", transform = {"[$it]"}) // seperator default = ','
//    //3개다 같은 결과를 반환함
//
//    var res4 = listOf(9,11,23,32).joinToString(" ")
//    println(res3)
//    println(res33)
//    println(res333)
//    println(res4)
//}

//fun main() {
//    val list = listOf('a','b','c').mapIndexed({idx, elem-> "[$idx, $elem]"})
//    //[[0, a], [1, b], [2, c]]
//    println(list)
//    val list2 = listOf('a', 'b', 'c').mapIndexed({ idx, _ -> "[$idx]" }) //[[0], [1], [2]]\
//    println(list2)
//    val list3 = listOf('a', 'b', 'c').indices.map{"[$it]"} //[[0], [1], [2]]
//    println(list3)
//
//}

//fun main() {
////    run{
////        -> println("A Lamda")   // 이렇게도 쓸수 있지만, 매개변수가 없으면 -> 를 쓰지 않는 것을 권장한다.
////    }
//    run{
//        println("Without args")
//    }
//}

//fun main() {
//    val isEven = {n:Int -> n%2 == 0 } // 람다를 변수에 담을수 있다.
//    println(isEven)
//}

//fun main() {
//    val divider = 5
//    val list = listOf(1,5,7,19).filter{it % divider == 0 } // 자바는 final, effective final만 가능. 코틀린은 값이 변경되어도 참조 가능
//    println(list)
//    var sum = 0
//    listOf(1,5,7,10).filter{it % 5 == 0}.forEach{sum += it}
//    println(sum)
//
//    val sum2 = listOf(1,5,7,10).filter{it % 5 ==0}.sum()
//    println(sum2)
//
//    //import java.util.Arrays;
//    //import java.util.List;
//    //
//    //public class Main {
//    //    public static void main(String[] args) {
//    //        List<Integer> numbers = Arrays.asList(1, 5, 7, 10);
//    //        int sum = numbers.stream()
//    //                         .filter(n -> n % 5 == 0)
//    //                         .mapToInt(Integer::intValue)
//    //                         .sum();
//    //
//    //        System.out.println(sum);
//    //    }
//    //}
//}

//var x = 100
//fun useX(){
////    var x = 100
//    x++ // 위 선언이 없으면 전역변수 값을 변경시킨다.
//}
//fun main() {
//    useX()
//    println(x)
//}

//fun main() {
//    val list1 = List(10){it}   //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]  // idx가 전달되는 람다
//    val list2 = List(10){0}  //[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//    val list3 = List(10){'a'+it} //[a, b, c, d, e, f, g, h, i, j]
//    val list4 = List(10){list3[it%3]} //[a, b, c, a, b, c, a, b, c, a]
//
//    //mutable
//    val list5 = MutableList(5,{10* (it+1)})  //[10, 20, 30, 40, 50]
//    val list6 = MutableList(5){10* (it+1)}  //[10, 20, 30, 40, 50]
//
//
//    println(list5)
//    println(list6)
//
//}

//fun main() {
//    val list = listOf(-3,-1,5,7,10)
//
//    val list1 = list.filter{it >0} //[5, 7, 10]
//    val list11 = list.filterNot{it >0} //[-3, -1]
//
//    val cnt = list.count{it >0} //3
//
//    val elem = list.find{it>0} //5
//    val elem2 = list.firstOrNull{it == 11} // null
//    val elem3 = list.lastOrNull{it>0} //10
//    val bool1 = list.any{it > 0} // true
//    val bool2 = list.all{it > 0} // false
//    val bool3 = list.none{it == 11} // true
//
//    val (pos, neg) = list.partition { it>0 } //([5, 7, 10], [-3, -1]) Pair 타입
////    pos // [5, 7, 10]
////    neg//[-3, -1]
//
//    val exList = listOf(1,2,3,null)
//    val resList= exList.filterNotNull() // [1, 2, 3]
//    val resList2 = exList.filterIsInstance<Int>() //[1,2,3]
//    val resList3 = exList.filterIndexed{idx,_-> idx>1} //[3, null]
//    val resList4 = exList.filterIndexed{ idx, _ -> idx>3 } //[]
////    val mut = mutableListOf<Int>()
////    val resList5 = exList.filterIndexedTo(mut) { idx, _ -> idx > 1 }
//    val resList6 = exList.asReversed() //[null, 3, 2, 1]
//    val resList7 = exList.shuffled()// 랜덤
//    val resList8 = exList.single()
//
//
//    println(resList8)
//
//
//}


//data class Product(
//    val description: String,
//    val price: Double
//)
//
//fun main() {
//    val products = listOf(
//        Product("bread", 2.0),
//        Product("wine", 5.0),
//    )
//
//    val sum1 = products.sumOf { it.price }
//    val obj = products.sortedByDescending { it.price }
//    val obj22 = products.sortedBy { it.price }
//    val obj2 = products.minByOrNull{it.price}
//
//    val take = products.take(2) //[Product(description=bread, price=2.0), Product(description=wine, price=5.0)]
//    val takeLast = products.takeLast(1); //[Product(description=wine, price=5.0)] (뒤에서 한개)
//
//    val drop = products.drop(1) // 원본 그대로있음 [Product(description=wine, price=5.0)]
//    val charList = List(5){'a'+ it}
//    val takeLastWhile = charList.takeLastWhile { it > 'b' } // [c, d, e]
//
//    println(obj22)
//}

//data class Message(
//    val sender : String,
//    val text : String,
//    val isRead : Boolean
//)
//
//fun main() {
//    val messages = listOf(
//        Message("Kitty","Hey!",true),
//        Message("Kitty","whrer are you?",false),
//        Message("Boss","Meeting today",false),
//    )
//
//    val unread = messages.filterNot(Message::isRead)
//    println(unread)
//
////    val sortedWith = messages.sortedWith(compareBy(Message::isRead, Message::sender))
////    println(sortedWith)
//
//
//}

//
//data class Message(
//    val sender : String,
//    val text : String,
//    val isRead : Boolean,
//    val attachments: List<Attachment>
//)
//
//data class Attachment(
//    val type :String,
//    val name :String
//)
//
//fun Message.isImportant() : Boolean =
//    text.contains("Salary increase") ||
//        attachments.any{
//            it.type == "image" &&
//                    it.name.contains("cat")
//        }
////
////
////fun main() {
////    val messages = listOf(Message("Boss","Lets's discuss goals"+"for next year", false,
////        listOf(Attachment("image","cute cats"))));
////
////    println(messages.any(Message::isImportant))
////}
//
//fun ignore(message : Message) =
//    !message.isImportant() &&
//    message.sender in setOf("Boss", "Mom")
//
//fun main() {
//    val text = "Let's discuss goals" + "for the next year";
//    val msgs = listOf(
//        Message("Boss", text, false, listOf()),
//        Message("Boss", text, false, listOf(
//            Attachment("image","cute cats")
//        )),
//    )
//
//    val filter = msgs.filter(::ignore)
//    val filterNot = msgs.filterNot(::ignore)
//
//    println(filter)
//    println(filterNot)
//}


//data class Student(
//    val id :Int,
//    val name: String,
//)
//
//fun main() {
//    val names = listOf("Bob", "Choi","Kim")
//    val students = names.mapIndexed { idx, name -> Student(idx, name) }
////    println(students)
//    val students1 = names.mapIndexed(::Student)
//    println(students1)
//}

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
//    println(goFrog(Frog(),Frog::speak))
//}
//
//val isPlus : (Int) ->  Boolean = {it > 0}
//
//fun main() {
//    val any = listOf(1, 2, -3).any(isPlus)
//    println(any)
//}


//val helloWorld: () -> String = { "Hello world!"}
//val sum : (Int, Int) -> Int = { x,y -> x+y}
//
//fun main() {
//    println(helloWorld())
//    println(sum(1,2))
//}

//fun main() {
//    repeat(4) {idx ->println("${idx}")}
//}

//fun main() {
//    val transform : (String) -> Int? = {
//        s:String -> s.toIntOrNull()
//    }
//
//    println(transform("112"))
//    println(transform("abc"))
//
//    val x = listOf("112","abc")
//    val mapNotNull = x.mapNotNull(transform) // null 이 아닌 녀석만
//    val mapNotNull1 = x.mapNotNull { it.toIntOrNull() }
//    println(mapNotNull)
//    println(mapNotNull1)
//
//}

//fun main() {
//    val retunTypeNullable : (String) -> Int? = {null}
//    var mightBeNull : ((String) -> Int)? = null
//
//    println(retunTypeNullable("abc"))
//
//    mightBeNull = {s -> s.length}
//    if (mightBeNull != null)
//        println(mightBeNull("abc"))
//}

// 리스트조작하기

//fun main() {
//    val left = List(4){'a' + it}
//    val right = List(4){'q' + it}
//    println(left.zip(right))
//    println(left.zip(0..4))
//    println((10..100).zip(right))}
//

//data class Person(
//    public val name: String,
//    public val id: Int,
//){
//    constructor(pair: Pair<String, Int>) : this(pair.first, pair.second)
//}

//fun main() {
//    val names = listOf("Bob","Jill","Jim")
//    val ids = listOf(1731, 9274, 8378)
//
//    val zip = names.zip(ids) { name, id -> Person(name, id) }
//    println(zip)
////    names.zip(ids).map{::Person}   <<< 이런 경우는 생성자 참조가 안됨 // 기본적인 경우에만 가능
//
//}


//fun main() {
//    val list = List(4){'a' + it}
//
//    val zipWithNext = list.zipWithNext() //[(a, b), (b, c), (c, d)]
//    println(zipWithNext)
//
//    val zipWithNext1 = list.zipWithNext() { a, b -> "$a$b" }
//    println(zipWithNext1) //[ab, bc, cd]
//
//
//}

//fun main() {
//    val list = listOf(
//        listOf(1,2),
//        listOf(4,5),
//        listOf(7,8),
//    )
//
//    println(list.flatten()) //[1, 2, 4, 5, 7, 8]
//
//}

//fun main() {
//    val intRange = 1..3
//
//    val mapped = intRange.map { a ->
//        intRange.map { b -> a to b }
//    }
//    println(mapped)
//}

//fun main() {
//    val pairList = (1..3).flatMap { a -> (1..3).map { b -> a to b } }
//    println(pairList)
//}

//enum class Suit {
//    Spade, Club, Heart, Diamond
//}
//
//enum class Rank(val faceValue: Int) {
//    Ace(1), Two(2), Three(3), Four(4), Five(5),
//    Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10),
//    Queen(10), King(10)
//}
//
//class Card(val rank: Rank, val suit: Suit) {
//    override fun toString(): String {
//        return "$rank of ${suit}s"
//    }
//}
//
//val deck: List<Card> =
//    Suit.values().flatMap { suit ->
//        Rank.values().map { rank ->
//            Card(rank, suit)
//        }
//    }
//
//fun main() {
//    val rand = Random(26)
//    repeat(7) {
//        println(deck.random(rand))
//    }
//
//}

//data class Person(
//    val name: String,
//    val age: Int
//)
//
//val names = listOf("Alice","Arthricia","Bob","Bill","Birdperson","Charlie","Crocubot","Franz","Revolio")
//val ages = listOf(21,15,25,25,42,21,42,21,33)
//
//fun person() : List<Person> =
//    names.zip(ages).map{(name,age) -> Person(name,age)}
//
////val person : List<Person> =
////    names.zip(ages).map{(name,age) -> Person(name,age)}
//fun main() {
//    val groupBy: Map<Int, List<Person>> = person().groupBy(Person::age)
//    //{21=[Person(name=Alice, age=21), Person(name=Charlie, age=21), Person(name=Franz, age=21)], 15=[Person(name=Arthricia, age=15)], 25=[Person(name=Bob, age=25), Person(name=Bill, age=25)], 42=[Person(name=Birdperson, age=42), Person(name=Crocubot, age=42)], 33=[Person(name=Revolio, age=33)]}
//    val groupBy1 = person().groupBy { it.age > 20 }
////    {true=[Person(name=Alice, age=21), Person(name=Bob, age=25), Person(name=Bill, age=25), Person(name=Birdperson, age=42), Person(name=Charlie, age=21), Person(name=Crocubot, age=42), Person(name=Franz, age=21), Person(name=Revolio, age=33)], false=[Person(name=Arthricia, age=15)]}
//    val (up, down) = person().partition { it.age > 20 }
//
//    val groupBy2 = person().groupBy { it.name.first() }
//    //{A=[Person(name=Alice, age=21), Person(name=Arthricia, age=15)], B=[Person(name=Bob, age=25), Person(name=Bill, age=25), Person(name=Birdperson, age=42)], C=[Person(name=Charlie, age=21), Person(name=Crocubot, age=42)], F=[Person(name=Franz, age=21)], R=[Person(name=Revolio, age=33)]}
//
//    val associateWith = person().associateWith { it.name }
////    {Person(name=Alice, age=21)=Alice, Person(name=Arthricia, age=15)=Arthricia, Person(name=Bob, age=25)=Bob, Person(name=Bill, age=25)=Bill, Person(name=Birdperson, age=42)=Birdperson, Person(name=Charlie, age=21)=Charlie, Person(name=Crocubot, age=42)=Crocubot, Person(name=Franz, age=21)=Franz, Person(name=Revolio, age=33)=Revolio}
//    val associateBy = person().associateBy { it.age }
//    //{21=Person(name=Franz, age=21), 15=Person(name=Arthricia, age=15), 25=Person(name=Bill, age=25), 42=Person(name=Crocubot, age=42), 33=Person(name=Revolio, age=33)}
//    // 중복된 값이 하나만 나왔음(맨나중에 생성되는 값만 포함됨)
//
//
//    println(associateBy)



//}

//fun main() {
//    val map = mapOf(1 to "one", 2 to "two")
//
////    println(map.getOrElse(0){"Zero"}) //Zero
//    val mutableMap = map.toMutableMap()
//    println(mutableMap.getOrPut(0){"Zero"}) //Zero
//    println(mutableMap) //{1=one, 2=two, 0=Zero}
//
//}

//fun main() {
//    val map = mapOf(1 to "one",
//        2 to "two", 3 to "three", 4 to "four")
//
//    val filterKeys = map.filterKeys { it % 2 == 1 }
//    val filterValues = map.filterValues { it.contains("o") }
//    val filter = map.filter { entry -> entry.key % 2 == 1 && entry.value.contains('o') }
//
//
//    println(filter)
//
//}


//fun main() {
//    val even = mapOf(2 to "two", 4 to "four")
//    val map = even.map { "${it.key} = ${it.value}" } //[2 = two, 4 = four]
//
//    val mapKeys = even.mapKeys { (num, _) -> -num }  // {-2=two, -4=four}
//    val newMap = even.mapKeys { (num, value) ->
//        // 값(value)을 변경해도 원본 맵에 영향을 미치지 않음 (대문자로 안바낌)
//        val newValue = value.uppercase()
//        -num
//    }

//    println(newMap) // {-2=two, -4=four}
//    println(even)   // {2=two, 4=four}



//    val mapValues = mapKeys.mapValues { (_, str) -> "minus $str" } // {-2=minus two, -4=minus four}
//
//    println(mapValues)

//    val map1 = even.map { (key, value) -> -key to "minus $value" }  // [(-2, minus two), (-4, minus four)]
//    val toMap = map1.toMap() // {-2=minus two, -4=minus four}
//
//    println(map1)
//    println(toMap)
//
//    val any = even.any { (key, _) -> key < 0 }
//    val all = even.all { (key, _) -> key > 0 }
//    val value = even.maxByOrNull { it.key }?.value
////    println(all)
//    println(value)

//시퀀스


//fun main() {
//    val map = listOf(1, 2, 3, 4).asSequence()
//        .filter { it % 2 == 0 }
//        .map { it * it }  // kotlin.sequences.TransformingSequence@1d81eb93
//
//
//    println(map.toString().substringBefore("@")) // kotlin.sequences.TransformingSequence
//    println(map.toList())
//
//}

//fun main() {
//    val generateSequence = generateSequence(1) { it + 1 } //kotlin.sequences.GeneratorSequence@3e3abc88
//
//    val toList = generateSequence.take(3).toList() //[1, 2, 3]
//    val sum = generateSequence.take(10).sum()  //55
//
//}

//fun main() {
//    val items = mutableListOf("first", "second", "third", "XXX", "4th")
//
//    val seq = generateSequence {
//        items.removeAt(0).takeIf { it != "XXX" }
//    }  // kotlin.sequences.ConstrainedOnceSequence@4f3f5b24
//
//    println(seq.toList())
//    println(seq.toList())
    //Exception in thread "main" java.lang.IllegalStateException: This sequence can be consumed only once.
    //	at kotlin.sequences.ConstrainedOnceSequence.iterator(SequencesJVM.kt:23)
    //	at kotlin.sequences.SequencesKt___SequencesKt.toList(_Sequences.kt:812)
    //	at chapter4.HyunJunSon.Ch04Kt.main(ch04.kt:530)
    //	at chapter4.HyunJunSon.Ch04Kt.main(ch04.kt)

//}

//지역함수
//fun main() {
//    val logMsg = StringBuffer()
//    fun log(message: String) = logMsg.appendLine(message)  // 지역함수
//    log("Starting Computation")
//    val x = 42
//    log("Computation Result: $x")
//    println(logMsg.toString())
//
//}

//fun main() {
//    fun String.exclaim() = "$this"
//    println("Hello".exclaim())
//}

//fun main() {
//    val list = listOf(1,2,3,4,5)
//    val value = 3
//    var result = ""
//    list.forEach tag@{
//        result += "$it"
//        if (it == value) return@tag
//    }
//    println(result) //12345
//
//}


//fun first() : (Int) -> Int {
//    val func = fun(i: Int) = i+1
//    println(func(1)) //2
//    return func
//}
//
//fun second() : (String) -> String {
//    val func2 = {s:String -> "$s!"}
//    println(func2("abc"))
//    return func2;
//}
//
//fun third() : () -> String {
//    fun greet() = "Hi!"
//    return ::greet
//}
//
//fun fourth() = fun() = "Hi!"
//
//fun fifth() = { "Hi!" }
//
//fun main() {
//    val funRef1 : (Int) -> Int = first()
//    val funRef2 : (String) -> String = second()
//    val funRef3 : () -> String = third()
//    val funRef4 : () -> String = fourth()
//    val funRef5 : () -> String = fifth()
//
//    println(funRef1(42))
//    println(funRef2("xyz"))
//    println(funRef3())
//    println(funRef4())
//    println(funRef5())
//
//    println(second()("xyz"))
//    println(third()())
//}


//fun main() {
//    val list = listOf(1,10,100,1000)
//    val hap = list.fold(0) { sum, n -> sum + n }
//    println(hap)
//}

//fun main(){
//    val list = listOf('a','b','c','d')
//    val fold = list.fold("*") { acc, elem -> "($acc)+$elem" } //((((*)+a)+b)+c)+d
//    val foldRight = list.foldRight("*") { elem, acc -> "$elem+($acc)" } //a+(b+(c+(d+(*))))
//
//
//    println(fold)
//    println(foldRight)
//
//}

//fun main() {
//    val chars = "A B C D E".split(" ")
//    val fold = chars.fold("*") { acc, e -> "$acc $e" } //* A B C D E
//    val foldRight = chars.foldRight("*") { elem, acc -> "$elem $acc" } //A B C D E *
//    val reduce = chars.reduce { acc, e -> "$acc $e" } // A B C D E
//    val reduceRight = chars.reduceRight { e, acc -> "$acc $e" } //E D C B A
//    //	•	acc는 초기값으로 리스트의 마지막 요소인 'E'를 가집니다.
//
//
//
////    println(fold)
////    println(foldRight)
//    println(reduce)
//    println(reduceRight)
//
//}

//fun main() {
//    val list = listOf(11,13,17,19)
//    val fold = list.fold(7) { sum, n -> sum + n } //67
//    val runningFold = list.runningFold(7) { sum, n -> sum + n } //[7, 18, 31, 48, 67]
//    val reduce = list.reduce { acc, e -> acc + e } //60
//    val runningReduce = list.runningReduce { sum, n -> sum + n } //[11, 24, 41, 60]
//    val result = list.runningFoldIndexed(0) { index, acc, num ->
//        println("Index: $index, Acc: $acc, Num: $num")
//        acc + num
//    }
//
//    println("Result: $result")
//
//
//    println(runningReduce)
//}

//재귀

//fun illegalState(){
//    throw IllegalStateException()
//}
//fun fail() = illegalState()
//fun main() {
//    fail()
//}

//fun recursive(i: Int) :Int = recursive(i+1)
//
//fun main() {
//    recursive(1)
//}

//private tailrec fun sum(n: Long, acc: Long) : Long =
//    if (n == 0L) acc else sum(n-1, acc+n)
//
//fun sum(n: Long) = sum(n,0)
//fun main() {
//    println(sum(2))
//    println(sum(10000))
//    println(sum(100000))
//}

//fun fibonacci(n: Int) : Long {
//    tailrec fun fibonacci(
//        n: Int,
//        current:Long,
//        next: Long
//    ): Long {
//        if (n == 0) return current
//        return fibonacci(
//            n-1, next, current+next
//        )
//    }
//    return fibonacci(n,0L, 1L)
//}
//
//fun main() {
//    val map = (0..8).map { fibonacci(it) }
//    println(map)
//
//}