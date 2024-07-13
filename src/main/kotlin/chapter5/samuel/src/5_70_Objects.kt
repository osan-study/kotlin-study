
object JustOne {
    val n = 2
    fun f() = n * 10
    fun g() = this.n * 20
}

open class Paint(val color: String) {
    open fun apply() = "Applying $color"
}

object Acrylic: Paint("Blue") {
    override fun apply() = "Acrylic, ${super.apply()}"
}

interface PaintPreparation {
    fun prepare(): String
}

object Prepare: PaintPreparation {
    override fun prepare() = "Scrape"
}

object Outer {
    object Nested {
        val a = "Outer.Nested.a"
    }
}

class HasObject {
    object Nested {
        val a = "HasObject.Nested.a"
    }
}

fun main() {
    // val x = JustOne() // 오류
    println("JustOne.n: ${JustOne.n}")
    println("JustOne.f(): ${JustOne.f()}")
    println("JustOne.g(): ${JustOne.g()}")

    println("Prepare.prepare(): ${Prepare.prepare()}")
    println("Paint(\"Green\").apply(): ${Paint("Green").apply()}")
    println("Acrylic.apply(): ${Acrylic.apply()}")

    println("Outer.Nested.a: ${Outer.Nested.a}")
    println("HasObject.Nested.a: ${HasObject.Nested.a}")
}