interface Building
interface Kitchen2

interface House2: Building {
    val kitchens: List<Kitchen2>
}

class Features {
    fun f1() = "feature1"
    fun f2() = "feature2"
}

class Form {
    private val features = Features()
    fun oper1() = features.f2() + features.f1()
    fun oper2() = features.f1() + features.f2()
}

class Engine {
    fun start() = println("engine start")
    fun end() = println("engine end")
}

class Wheel {
    fun inflate(psi: Int) = println("wheel inflate($psi)")
}

class Window(val side: String) {
    fun rollUp() = println("$side Window roll up")
    fun rollDown() = println("$side Window roll down")
}

class Door(val side: String) {
    val window = Window(side)
    fun open() = println("$side Door open")
    fun close() = println("$side Door close")
}

class Car {
    val engine = Engine()
    val wheel = List(4) { Wheel() }
    val leftDoor = Door("left")
    val rightDoor = Door("right")
}

fun main() {

    val car = Car()
    print("car.leftDoor.open(): ")
    car.leftDoor.open()
    print("car.rightDoor.window.rollUp(): ")
    car.rightDoor.window.rollUp()
    print("car.wheel[0].inflate(72): ")
    car.wheel[0].inflate(72)
    print("car.engine.start(): ")
    car.engine.start()

}