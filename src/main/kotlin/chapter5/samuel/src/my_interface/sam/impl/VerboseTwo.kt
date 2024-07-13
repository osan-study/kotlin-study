package chapter5.samuel.src.my_interface.sam.impl

import chapter5.samuel.src.my_interface.sam.TwoArg

class VerboseTwo : TwoArg {
    override fun g(i: Int, j: Int) = i + j
}