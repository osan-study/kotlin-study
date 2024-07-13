

open class Heater {
    fun heat(temperature: Int) =
        "Heating to $temperature"
}

fun warm(heater: Heater) {
    println("heater.heat(70): ${heater.heat(70)}")
}

//class HVAC : Heater() {
//    fun cool(temperature: Int) {
//        "Cooling to $temperature"
//    }
//}

//fun warmAndCool(hvac: HVAC) {
//    println("hvac.heat(70): ${hvac.heat(70)}")
//    println("hvac.cool(60): ${hvac.cool(60)}")
//}

fun Heater.cool(temperature: Int) = "Cooling to $temperature"

fun warmAndCool(heater: Heater) {
    println("heater.heat(70): ${heater.heat(70)}")
    println("heater.cool(60): ${heater.cool(60)}")
}

class TemperatureDelta(
    val current: Double,
    val target: Double
)

fun TemperatureDelta.heat() {
    if(current < target)
        println("heating to $target")
}

fun TemperatureDelta.cool() {
    if(current > target)
        println("cooling to $target")
}

fun adjust(deltaT: TemperatureDelta) {
    deltaT.heat()
    deltaT.cool()
}

class X
fun X.f() {}

class Y
fun Y.f() {}

fun callF(x: X) = x.f()
fun callF(y: Y) = y.f()


interface LibType {
    fun f1()
    fun f2()
}

fun utility1(lt: LibType) {
    lt.f1()
    lt.f2()
}

fun utility2(lt: LibType) {
    lt.f2()
    lt.f1()
}

class MyClass {
    fun g() = println("g()")
    fun h() = println("h()")
}

fun useMyClass(mc: MyClass) {
    mc.g()
    mc.h()
}

class MyClassAdaptedForLib : LibType {
    val field  = MyClass()
    override fun f1() = field.h()
    override fun f2() = field.g()
}

class Z(var i: Int = 0) {
    private var j = 0
    fun increment() {
        i++
        j++
    }
}

fun Z.decrement() {
    i--
//    j--
}

open class Base1 {
    open fun f() = println("Base1.f()")
}

class Derived1: Base1() {
    override fun f() = println("Derived1.f()")
}

fun Base1.g() = println("Base1.g()")
fun Derived1.g() = println("Derived1.g()")

fun useBase(b: Base1) {
    println("Received  ${b::class.simpleName}")
    b.f()
    b.g()
}

interface Device {
    val model: String
    val productionYear: Int
    fun overpriced() = model.startsWith("i")
    fun outdated() = productionYear < 2050
}

class MyDevice (
    override val model: String,
    override val productionYear: Int
): Device

interface Device2 {
    val model: String
    val productionYear: Int
}

fun Device2.overpriced() = model.startsWith("i")
fun Device2.outdated() = productionYear < 2050

class MyDevice2 (
    override val model: String,
    override val productionYear: Int
): Device2

fun main() {
    val heater = Heater()
//    val hvac = HVAC()
//    warm(heater)
//    warm(hvac)
//    warmAndCool(hvac)

    warmAndCool(heater)

    print("adjust(TemperatureDelta(60.0, 70.0)): ")
    adjust(TemperatureDelta(60.0, 70.0))
    print("adjust(TemperatureDelta(80.0, 60.0)): ")
    adjust(TemperatureDelta(80.0, 60.0))

    val x = X()
    val y = Y()
    x.f()
    y.f()
    callF(x)
    callF(y)

    val mc = MyClassAdaptedForLib()
    utility1(mc)
    utility2(mc)
    useMyClass(mc.field)

    useBase(Base1())
    useBase(Derived1())

    val gadget: Device = MyDevice("my first phone", 2000)
    println("gadget.outdated(): ${gadget.outdated()}")
    println("gadget.overpriced(): ${gadget.overpriced()}")

    val gadget2: Device2 = MyDevice2("my first phone", 2000)
    println("gadget2.outdated(): ${gadget2.outdated()}")
    println("gadget2.overpriced(): ${gadget2.overpriced()}")
}