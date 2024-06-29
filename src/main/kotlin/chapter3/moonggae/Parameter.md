## 31. Arguments

> 💡 Remind <br />
> Parameter: 전달할 정보를 넣을 장소(placeholder) <br />
> Argument: 함수에 파라미터를 통해 전달하는 실제 값

- 함수를 호출할 때 인자의 이름을 표기하면 가독성이 좋다.
- 인자의 이름을 표기할 때 순서를 바꾼다면 모든 인자의 이름을 표기해야 한다.
- 파라미터를 정의할 때 디폴트 값을 지정할 수 있다.
- 함수를 호출할 때 디폴트 값이 있는 인자는 생략할 수 있다.

```kotlin
// Parameter.kt

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
    
    // ...
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
```