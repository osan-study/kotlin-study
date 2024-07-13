
open class GreatApe2 (
    val weight: Double,
    val age: Int
)

open class Bonobo2(weight: Double, age: Int) : GreatApe2(weight, age)

open class Chimpanzee2(weight: Double, age: Int) : GreatApe2(weight, age)

class BonoboB2(weight: Double, age: Int) : Bonobo2(weight, age)

fun GreatApe2.info() = "wt: $weight, age: $age"

open class SuperClass1(val i: Int)
class SubClass1(i: Int) : SuperClass1(i)

open class SuperClass2()
class SubClass2() : SuperClass2()


open class House(
    val address: String,
    val state: String,
    val zip: String
) {
    constructor(fullAddress: String) :
            this(fullAddress.substringBefore(", "),
                fullAddress.substringAfter(", ").substringBefore(" "),
                fullAddress.substringAfterLast(" "))

    val fullAddress: String
        get() = "$address, $state $zip"
}

class VacationHouse(
    address: String,
    state: String,
    zip: String,
    val startMonth: String,
    val endMonth: String
) : House(address, state, zip) {
    override fun toString() =
        "Vacation house at $fullAddress from $startMonth to $endMonth"
}

class TreeHouse(
    val name: String
) : House("Tree Street, TR 00000") {
    override fun toString() =
        "$name tree house at $fullAddress"
}

open class Base(val i: Int)

class Derived : Base {
    constructor(i: Int) : super(i)
    constructor() : this(9)
}

fun main() {
    println("GreatApe2(100.0, 12).info(): ${GreatApe2(100.0, 12).info()}")
    println("Bonobo2(100.0, 12).info(): ${Bonobo2(100.0, 12).info()}")
    println("Chimpanzee2(100.0, 12).info(): ${Chimpanzee2(100.0, 12).info()}")
    println("BonoboB2(100.0, 12).info(): ${BonoboB2(100.0, 12).info()}")

    val vacationHouse = VacationHouse(
        address = "8 Target St.",
        state = "KS",
        zip = "66632",
        startMonth = "May",
        endMonth = "September"
    )

    println("vacationHouse: $vacationHouse")
    println("TreeHouse(\"Oak\"): ${TreeHouse("Oak")}")

    val d1 = Derived(11)
    println("d1.i: ${d1.i}")
    val d2 = Derived()
    println("d2.i: ${d2.i}")
}