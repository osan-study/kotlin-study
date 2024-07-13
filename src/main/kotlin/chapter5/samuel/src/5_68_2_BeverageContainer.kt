
interface BeverageContainer {
    fun open(): String
    fun close(): String
}

class Can : BeverageContainer {
    override fun open() = "Pop Top"
    override fun close() = "Can: Pour"
}

open class Bottle : BeverageContainer {
    override fun open() = "Remove Cap"
    override fun close() = "Bottle: Pour"
}

class GlassBottle : Bottle()
class PlasticBottle : Bottle()

fun BeverageContainer.recycle() =
    when(this) {
        is Can -> "Recycle Can"
        is GlassBottle -> "Recycle Glass"
        else -> "Landfill"
    }

fun main() {
    val refrigerator = listOf(
        Can(), GlassBottle(), PlasticBottle()
    )

    println("refrigerator.map { it.open() }: ${refrigerator.map { it.open() }}")
    println("refrigerator.map { it.recycle() }: ${refrigerator.map { it.recycle() }}")
}