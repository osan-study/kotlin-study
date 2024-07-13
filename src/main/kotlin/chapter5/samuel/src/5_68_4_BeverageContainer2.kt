
interface BeverageContainer2 {
    fun open(): String
    fun close() = "$name: Pour"
    fun recycle(): String
}

abstract class Can2 : BeverageContainer2 {
    override fun open() = "Pop Top"
}

class SteelCan : Can2() {
    override fun recycle() = "Recycle Steel"
}
class AluminumCan : Can2() {
    override fun recycle() = "Recycle Aluminum"
}

abstract class Bottle2 : BeverageContainer2 {
    override fun open() = "Remove Cap"
}

class GlassBottle2 : Bottle2() {
    override fun recycle() = "Recycle Glass"
}

abstract class PlasticBottle2 : Bottle2()

class PETBottle : PlasticBottle2() {
    override fun recycle() = "Recycle PET"
}
class HDPEBottle : PlasticBottle2() {
    override fun recycle() = "Recycle HDPE"
}

//fun BeverageContainer2.recycle() =
//    when(this) {
//        is Can2 -> "Recycle Can"
//        is Bottle2 -> "Recycle Glass"
//    }
//
//fun BeverageContainer2.recycle2() =
//    when(this) {
//        is Can2 -> when(this) {
//            is SteelCan -> "Recycle Steel"
//            is AluminumCan -> "Recycle Aluminum"
//        }
//        is Bottle2 -> when(this) {
//            is GlassBottle2 -> "Recycle Glass"
//            is PlasticBottle2 -> when(this) {
//                is PETBottle -> "Recycle PETBottle"
//                is HDPEBottle -> "Recycle HDPEBottle"
//            }
//        }
//    }

fun main() {
    val refrigerator = listOf(
        SteelCan(), AluminumCan(),
        GlassBottle2(),
        PETBottle(), HDPEBottle()
    )

    println("refrigerator.map { it.open() }: ${refrigerator.map { it.open() }}")
    println("refrigerator.map { it.recycle() }: ${refrigerator.map { it.recycle() }}")
}