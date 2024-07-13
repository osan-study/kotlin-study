
interface Controls {
    fun up(velocity: Int): String
    fun down(velocity: Int): String
    fun left(velocity: Int): String
    fun right(velocity: Int): String
    fun forward(velocity: Int): String
    fun back(velocity: Int): String
    fun turboBoost(): String
}

class SpaceShipControls : Controls {
    override fun up(velocity: Int) = "up $velocity"
    override fun down(velocity: Int) = "down $velocity"
    override fun left(velocity: Int) = "left $velocity"
    override fun right(velocity: Int) = "right $velocity"
    override fun forward(velocity: Int) = "forward $velocity"
    override fun back(velocity: Int) = "back $velocity"
    override fun turboBoost() = "turboBoost"
}

class ExplicitControls : Controls {
    private val controls = SpaceShipControls()
    override fun up(velocity: Int) = controls.up(velocity)
    override fun down(velocity: Int) = controls.down(velocity)
    override fun left(velocity: Int) = controls.left(velocity)
    override fun right(velocity: Int) = controls.right(velocity)
    override fun forward(velocity: Int) = controls.forward(velocity)
    override fun back(velocity: Int) = controls.back(velocity)
    override fun turboBoost() = controls.turboBoost() + " ... boooooost!"
}

interface AI
class A1 : AI

class B1(val a: A1) : AI by a

class DelegatedControls (private val controls: SpaceShipControls = SpaceShipControls())
    : Controls by controls {
        override fun turboBoost() = "${controls.turboBoost()} ... Booooost!"
    }

interface Rect {
    fun paint(): String
}

class ButtonImage (
    val width: Int,
    val height: Int
) : Rect {
    override fun paint() = "painting ButtonImage($width, $height)"
}

interface MouseManager {
    fun clicked(): Boolean
    fun hovering(): Boolean
}

class UserInput : MouseManager {
    override fun clicked() = true
    override fun hovering() = true
}

class Button (
    val width: Int,
    val height: Int,
    var image: Rect = ButtonImage(width, height),
    private var input: MouseManager = UserInput()
) : Rect by image, MouseManager by input

fun main() {
    val controls = ExplicitControls()
    println("controls.forward(100): ${controls.forward(100)}")
    println("controls.turboBoost(): ${controls.turboBoost()}")

    var controls2 = DelegatedControls()
    println("controls2.forward(100): ${controls2.forward(100)}")
    println("controls2.turboBoost(): ${controls2.turboBoost()}")

    val button = Button(100, 50)
    println("button.paint(): ${button.paint()}")
    println("button.clicked(): ${button.clicked()}")
    println("button.hovering(): ${button.hovering()}")

    val rect: Rect = button
    val mouseManager: MouseManager = button
}