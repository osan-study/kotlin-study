fun main() {

//    컴파일 오류 (문은 결과가 아니라서 값으로 저장할 수 없음)
//    val f = for (i in 1..10) {
//
//    }

    println(unitFun())
    val u1: Unit = println(42)
    println(u1)
    val u2 = println(0)
    println(u2)

    val result1 = if(11 > 42) 9 else 5
    val result2 = if(1 < 2) {
        val a = 11
        a + 42
    } else 42

    val result3 =
        if('x' < 'y')
            println("x < y")
        else
            println("x > y")

    println("result1: $result1")
    println("result2: $result2")
    println("result3: $result3")

    var i = 10
    println(i++)
    println(i)
    var j = 20
    println(++j)
    println(j)

    var ii = 1
    println(ii++ + ++ii)
    println(ii++ + 10)
    println(20 * ++ii)

}

fun unitFun() = Unit