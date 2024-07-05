//fun factorial(n: Long): Long {
//    if (n <= 1) return 1
//    return n * factorial(n - 1)
//}
//
//private tailrec fun factorial2(n: Long): Long {
//    if (n <= 1) return 1
//    return n * factorial2(n - 1)
//}
//
//private fun fibonacci(n: Int): Long {
//    if (n == 0) return 0
//    else if (n == 1) return 1
//    else return fibonacci(n - 1) + fibonacci(n - 2)
//}
//
//private fun fibonacci2(n: Int): Long {
//    tailrec fun fibo(n: Int, current: Long, next: Long): Long {
//        if (n == 0) return current
//        return fibo(n - 1, next, current + next)
//    }
//    return fibo(n, 0L, 1L)
//}
//
//fun main() {
//
//    println("factorial(5): ${factorial(5)}")
//    println("factorial(17): ${factorial(17)}")
//
//    println("factorial2(5): ${factorial2(5)}")
//    println("factorial2(17): ${factorial2(17)}")
//
//    println("fibonacci(0) ${fibonacci(0)}")
//    println("fibonacci(40) ${fibonacci(40)}")
//
//    println("fibonacci2(0) ${fibonacci2(0)}")
//    println("fibonacci2(40) ${fibonacci2(40)}")
//}