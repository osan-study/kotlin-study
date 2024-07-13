package chapter5.samuel.src.my_interface.sam.impl

import chapter5.samuel.src.my_interface.sam.OneArg

class VerboseOne : OneArg {
    override fun g(n: Int) = n + 47
}