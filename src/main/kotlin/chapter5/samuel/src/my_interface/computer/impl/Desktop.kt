package chapter5.samuel.src.my_interface.computer.impl

import chapter5.samuel.src.my_interface.computer.Computer

class Desktop : Computer {
    override fun prompt() = "Hello Desktop"
    override fun calculateAnswer() = 11
}