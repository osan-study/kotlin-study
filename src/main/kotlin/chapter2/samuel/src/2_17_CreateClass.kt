class Giraffe
class Bear
class Hippo

class Dog {
    fun bark() = "yip!"
}

class Cat {
    fun meow() = "mrrrow!"
}

class Hamster {
    var i: Int = 3
    fun speak() = "Squeak! "
    fun exercise() =
        this.speak() + speak() + "Running on wheel"

    fun explainThis(i: Int) = this.i + i // 멤버 변수 i 와 파라미터 i 를 덧셈연산
}

fun main() {
    val g1 = Giraffe()
    val g2 = Giraffe()
    val b = Bear()
    val h = Hippo()

    println("g1: $g1")
    println("g2: $g2")
    println("b: $b")
    println("h: $h")

    val dog = Dog()
    println("dog.bark(): ${dog.bark()}")

    val cat = Cat()
    val m1 = cat.meow()
    println("cat.meow(): $m1")

    val hamster = Hamster()
    println("hamster.exercise(): ${hamster.exercise()}")
    println("hamster.explainThis(): ${hamster.explainThis(5)}")

}