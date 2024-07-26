package chapter5.moonggae.nested

import atomictest.eq
import chapter5.moonggae.nested.Ticket.Seat.*

class Ticket(
    val name: String,
    val seat: Seat = Coach
) {
    enum class Seat {
        Coach,
        Premium,
        Business,
        First
    }
    fun upgrade(): Ticket {
        val newSeat = entries[
            (seat.ordinal + 1)
                .coerceAtMost(First.ordinal)
        ]
        return Ticket(name, newSeat)
    }
    fun meal() = when(seat) {
        Coach -> "Bag Meal"
        Premium -> "Bag Meal with Cookie"
        Business -> "Hot Meal"
        First -> "Private Chef"
    }
    override fun toString() = "$seat"
}

fun main() {
    var tickets = listOf(
        Ticket("Jerry"),
        Ticket("Summer", Premium),
        Ticket("Squanchy", Business),
        Ticket("Beth", First)
    )
    tickets.map(Ticket::meal) eq
            "[Bag Meal, Bag Meal with Cookie, " +
            "Hot Meal, Private Chef]"
    tickets eq "[Coach, Premium, Business, First]"

    tickets = tickets.map(Ticket::upgrade)
    tickets eq "[Premium, Business, First, First]"

    tickets.map(Ticket::meal) eq
            "[Bag Meal with Cookie, Hot Meal, Private Chef, Private Chef]"
}