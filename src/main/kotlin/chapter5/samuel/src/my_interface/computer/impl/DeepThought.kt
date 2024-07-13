package chapter5.samuel.src.my_interface.computer.impl

import chapter5.samuel.src.my_interface.computer.Computer

class DeepThought : Computer {
    override fun prompt() = "Thinking"
    override fun calculateAnswer() = 42
}