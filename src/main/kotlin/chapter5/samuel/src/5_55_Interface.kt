import chapter5.samuel.src.my_interface.computer.impl.DeepThought
import chapter5.samuel.src.my_interface.computer.impl.Desktop
import chapter5.samuel.src.my_interface.computer.impl.Quantum
import chapter5.samuel.src.my_interface.hotness.impl.SpiceLevel
import chapter5.samuel.src.my_interface.player.impl.Food
import chapter5.samuel.src.my_interface.player.impl.Robot
import chapter5.samuel.src.my_interface.player.impl.Wall
import chapter5.samuel.src.my_interface.sam.OneArg
import chapter5.samuel.src.my_interface.sam.TwoArg
import chapter5.samuel.src.my_interface.sam.ZeroArg
import chapter5.samuel.src.my_interface.sam.delayAction
import chapter5.samuel.src.my_interface.sam.impl.VerboseOne
import chapter5.samuel.src.my_interface.sam.impl.VerboseTwo
import chapter5.samuel.src.my_interface.sam.impl.VerboseZero

fun main() {
    val computers = listOf(
        Desktop(), DeepThought(), Quantum()
    )
    println("computers.map { it.calculateAnswer() }: ${computers.map { it.calculateAnswer() }}")
    println("computers.map { it.prompt()}: ${computers.map { it.prompt() }}")

    val players = listOf(
        Food(), Robot(), Wall('|')
    )

    println("players.map { it.symbol }: ${players.map { it.symbol }}")

    println("SpiceLevel.values().map { it.feedback() }: ${SpiceLevel.values().map { it.feedback() }}")

    val verboseZero = VerboseZero()
    val samZero = ZeroArg { 11 }
    val verboseOne = VerboseOne()
    val samOne = OneArg { it + 47 }
    val verboseTwo = VerboseTwo()
    val samTwo = TwoArg { i, j -> i + j }

    println("verboseZero.f() == samZero.f(): ${verboseZero.f() == samZero.f()}")
    println("verboseOne.g(92) == samOne.g(92): ${verboseOne.g(92) == samOne.g(92)}")
    println("verboseTwo.g(11, 47) == samTwo.g(11, 47): ${verboseTwo.g(11, 47) == samTwo.g(11, 47)}")

    delayAction { println("TTT") }

}