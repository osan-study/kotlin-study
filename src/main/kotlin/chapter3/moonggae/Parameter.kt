package chapter3.moonggae

import java.time.LocalDateTime
import java.util.UUID

data class Player(
    val uid: UUID = UUID.randomUUID(),
    var nickname: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var bannedAt: LocalDateTime? = null,
    var money: Int = 0,
    val friends: MutableSet<Player> = mutableSetOf()
) {
    fun ban(
        bannedAt: LocalDateTime = LocalDateTime.now(),
        removeMoney: Boolean = false,
        removeFriends: Boolean = false
    ) {
        this.bannedAt = bannedAt
        if (removeMoney) money = 0
        if (removeFriends) this.friends.clear()
    }

    fun addFriend(otherPlayer: Player) {
        friends.add(otherPlayer)
    }

    fun earnMoney(amount: Int = 1) {
        this.money += amount
    }

    fun earnMoney() {
        this.money += 0
    }
}

fun main() {
    val ordinaryUser = Player(nickname = "dragon slayer")
    val cheater = Player(nickname = "admin")

    cheater.addFriend(ordinaryUser)
    cheater.money = Int.MAX_VALUE

    println(cheater.toPrettyString())
    println("\ncheater.ban()")
    cheater.ban()
    println(cheater.toPrettyString())

    println("\ncheater.ban(removeFriends = true, removeMoney = true)")
    cheater.ban(
        removeFriends = true,
        removeMoney = true
    )
    println(cheater.toPrettyString())
}