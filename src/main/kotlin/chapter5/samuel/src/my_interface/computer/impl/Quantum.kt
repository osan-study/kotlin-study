package chapter5.samuel.src.my_interface.computer.impl

import chapter5.samuel.src.my_interface.computer.Computer

class Quantum : Computer {
    override fun prompt() = "Probably..."
    override fun calculateAnswer() = -1
}