
data class Automobile(val brand: String)

class RigidHolder(private val a: Automobile) {
    fun getValue() = a
}

class GenericHolder<T> (private val value: T) {
    fun getValue() = value
}

class AnyHolder(private val value: Any) {
    fun getValue() = value
}

class MyDog {
    fun bark() = "Ruff!"
}

fun main() {
    val holder = RigidHolder(Automobile("BMW"))
    println("holder.getValue() == Automobile(brand = \"BMW\"): ${holder.getValue() == Automobile(brand = "BMW")}")

    val h1 = GenericHolder(Automobile("Ford"))
    val a: Automobile = h1.getValue()
    println("a == Automobile(brand=\"Ford\"): ${a == Automobile(brand = "Ford")}")

    val anyHolder = AnyHolder(MyDog())
    val any = holder.getValue()
//    any.bark()

    val genericHolder = GenericHolder(MyDog())
    val generic = genericHolder.getValue()
    println("generic.bark(): ${generic.bark()}")

}