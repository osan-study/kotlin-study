package chapter1.moonggae.util

import kotlin.reflect.KFunction0

fun runExample(d: KFunction0<Unit>) {
    println("--- ${d.name} ---")
    d.invoke()
    println()
}