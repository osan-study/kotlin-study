package chapter1.HyunJunSon

fun main() {
    for (c in "atpbce")
        println(check(c))
}

fun check(ch: Char) = ch in 'a'..'k';

fun printIsDigit(ch: Char) {
    if (ch in '0'..'9') {
        println("$ch is a digit.")
    } else
    println("$ch is not a digit.")
}

// 명시적인 반환 값이 없으므로 Unit이 반환됨
// return 1을 하면 아래 에러가 발생한다.
//Return type mismatch: expected 'kotlin.Unit', actual 'kotlin.Int'.}