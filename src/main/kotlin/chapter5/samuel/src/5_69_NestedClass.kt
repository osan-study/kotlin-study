import java.lang.reflect.Type
import kotlin.random.Random


class Airport(private val code: String) {
    open class Plane {
        fun contact(airport: Airport) = "Contacting ${airport.code}"
    }

    private class PrivatePlane : Plane()
    fun privatePlane() : Plane = PrivatePlane()
}

abstract class Cleanable(val id: String) {
    open val parts: List<Cleanable> = listOf()
    fun clean(): String {
        val text = "$id clean"
        if(parts.isEmpty()) return text
        return "${parts.joinToString(" ", "(", ")", transform = Cleanable::clean)} $text\n"
    }
}

class House3 : Cleanable("House") {
    override val parts: List<Cleanable> = listOf(
        Bedroom("Master Bedroom"),
        Bedroom("Guest Bedroom")
    )
    class Bedroom(id: String) : Cleanable(id) {
        override val parts: List<Cleanable> = listOf(Toilet(), Sink())
        class Toilet : Cleanable("Toilet")
        class Sink : Cleanable("Sink")
    }
}

fun localClass() {
    open class Amphibian
    class Frog : Amphibian()
    val amphibian: Amphibian = Frog()
}

interface Amphibian

fun createAmphibian() : Amphibian {
    class Frog : Amphibian
    return Frog()
}

interface Item {
    val type: Type
    data class Type(val type: String)
}

class Bolt(type: String) : Item {
    override val type = Item.Type(type)
}

class Ticket(
    val name: String,
    val seat: Seat = Seat.Coach
) {
    enum class Seat {
        Coach,
        Premium,
        Business,
        First
    }
    fun upgrade(): Ticket {
        val newSeat = Seat.values()[
            (seat.ordinal + 1)
                .coerceAtMost(Seat.First.ordinal)
        ]
        return Ticket(name, newSeat)
    }
    fun meal() = when(seat) {
        Seat.Coach -> "Bag Meal"
        Seat.Premium -> "Bag Meal with Cookie"
        Seat.Business -> "Hot Meal"
        Seat.First -> "Private Chef"
    }
    override fun toString() = "$seat"
}

interface Game {
    enum class State { Playing, Finished }
    enum class Mark { Blank, X, O }
}

class FillIt (
    val side: Int = 3, randomSeed: Int = 0
): Game {
    val rand = Random(randomSeed)
    private var state = Game.State.Playing
    private val grid = MutableList(side * side) { Game.Mark.Blank }
    private var player = Game.Mark.X
    fun turn() {
        val blanks = grid.withIndex().filter { it.value == Game.Mark.Blank }
        if(blanks.isEmpty()) {
            state = Game.State.Finished
        } else {
            grid[blanks.random(rand).index] = player
            player = if (player == Game.Mark.X) Game.Mark.O else Game.Mark.X
        }
    }
    fun play() {
        while(state != Game.State.Finished) {
            turn()
        }
    }

    override fun toString() = grid.chunked(side).joinToString("\n")

}

fun main() {
    val denver = Airport("DEN")
    var plane = Airport.Plane()
    println("plane.contact(denver): ${plane.contact(denver)}")

    val frankFurt = Airport("FRA")
    plane = frankFurt.privatePlane()

    println("plane.contact(frankFurt): ${plane.contact(frankFurt)}")

    println("House3().clean(): ${House3().clean()}")

    val amphibian = createAmphibian()
//    println("amphibian as Frog: ${amphibian as Frog}")

    val items = listOf(
        Bolt("Slotted"), Bolt("Hex")
    )

    println("items.map(Item::type): ${items.map(Item::type)}")

    val tickets = listOf(
        Ticket("Jerry"),
        Ticket("Summer", Ticket.Seat.Premium),
        Ticket("Samu", Ticket.Seat.Business),
        Ticket("Wilson", Ticket.Seat.First)
    )
    println("tickets.map(Ticket::meal): ${tickets.map(Ticket::meal)}")

    val game = FillIt(8, 17)
    game.play()
    println("game: $game")
}