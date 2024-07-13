import java.sql.RowId

class WithSecondary(i: Int) {

    init {
        println("Primary: $i")
    }

    constructor(c: Char): this(c - 'A') {
        println("Secondary: '$c'")
    }

    constructor(s: String): this(s.first()) {
        println("Secondary: \"$s\"")
    }

}

enum class Material {
    Ceramic, Metal, Plastic
}

class GardenItem(val name: String) {
    var material: Material = Material.Plastic

    constructor(name: String, material: Material) : this(name) {
        this.material = material
    }

    constructor(material: Material) : this("Strange Thing", material)

    override fun toString() = "$material $name"

}

fun main() {
    println("WithSecondary(1): ${WithSecondary(1)}")
    println("WithSecondary('D'): ${WithSecondary('D')}")
    println("WithSecondary(\"Last Constructor\"): ${WithSecondary("Last Constructor")}")

    println("GardenItem(\"Elf\").material: ${GardenItem("Elf").material}")
    println("GardenItem(\"Snowman\").material: ${GardenItem("Snowman").material}")
    println("GardenItem(\"Gazing Ball\", Material.Metal).material: ${GardenItem("Gazing Ball", Material.Metal).material}")
    println("GardenItem(Material.Ceramic).material: ${GardenItem(Material.Ceramic).material}")
}