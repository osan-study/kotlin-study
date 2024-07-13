package chapter5.samuel.src.my_interface.sam


fun interface ZeroArg {
    fun f(): Int
}

fun interface OneArg {
    fun g(n: Int): Int
}

fun interface TwoArg {
    fun g(i: Int, j: Int): Int
}