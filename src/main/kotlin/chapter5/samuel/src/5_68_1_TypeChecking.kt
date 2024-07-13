
val Any.name
    get() = this::class.simpleName

interface Insect {
    fun walk() ="$name: walk"
    fun fly() = "$name: fly"
}

class HouseFly : Insect

// 벼룩
class Flea : Insect {
    override fun fly() = throw Exception("Flea cannot fly")
    fun crawl() = "Flea: crawl"
}

fun Insect.basic() = walk() + " " + if(this is Flea) crawl() else fly()

interface SwimmingInsect: Insect {
    fun swim() = "$name: Swim"
}

interface WaterWalker: Insect {
    fun walkWater() = "$name: walk on water"
}

class WaterBeetle : SwimmingInsect
class WaterStrider : WaterWalker
class WhirligigBeetle : SwimmingInsect, WaterWalker

fun Insect.water() =
    when(this) {
        is SwimmingInsect -> swim()
        is WaterWalker -> walkWater()
        else -> "$name: drown"
    }

interface Shape2 {
    fun draw(): String
}

class Circle2 : Shape2 {
    override fun draw() = "Circle2: Draw"
}

class Square2 : Shape2 {
    override fun draw() = "Square2: Draw"
    fun rotate() = "Square2: Rotate"
}

class Triangle2 : Shape2 {
    override fun draw() = "Triangle2: Draw"
    fun rotate() = "Triangle2: Rotate"
}

fun turn(s: Shape2) =
    when(s) {
        is Square2 -> s.rotate()
        else -> ""
    }

fun turn2(s: Shape2) =
    when(s) {
        is Square2 -> s.rotate()
        is Triangle2 -> s.rotate()
        else -> ""
    }

fun main() {
    val insects = listOf(
        HouseFly(), Flea(), WaterStrider(),
        WaterBeetle(), WhirligigBeetle()
    )
    println("insects.map {it.basic()}: ${insects.map {it.basic()}}")
    println("insects.map {it.water()}: ${insects.map {it.water()}}")

    val shapes = listOf(Circle2(), Square2())
    println("shapes.map { it.draw() }: ${shapes.map { it.draw() }}")
    println("shapes.map { turn(it) }: ${shapes.map { turn(it) }}")

    val shapes2 = listOf(Circle2(), Square2(), Triangle2())
    println("shapes2.map { it.draw() }: ${shapes2.map { it.draw() }}")
    println("shapes2.map { turn(it) }: ${shapes2.map { turn(it) }}")
    println("shapes2.map { turn2(it) }: ${shapes2.map { turn2(it) }}")
}