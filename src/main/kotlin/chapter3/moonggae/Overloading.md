## 32. Overloading

- 같은 함수 이름을 사용하고 파라미터 목록을 다르게 정의한 것을 오버로딩 이라고 함.
- 리턴 타입은 오버로딩 대상이 아님
- 확장 함수도 오버로딩 할 수 있음

> 💡 디폴트 인자를 흉내 내기 위해 확장 함수를 사용하지 말 것
> ```kotlin
> // Bad 
> fun f(n: Int) = n + 373
> fun f() = f(0)
> ```
> ```kotlin
> // Good
> fun f(n: Int = 0) = n + 373
> ```

- 시그니처가 같은 확장 함수는 사용할 수 없음 (멤버 함수를 우선시함)
- 함수 오버로딩과 디폴트 인자를 함께 사용하는 경우, 가장 가깝게 일치되는 함수를 호출

```kotlin
// Parameter.kt
data class Player(
    // ...
    var money: Int = 0,
    // ...
) {
    // ...
    fun earnMoney(amount: Int = 1) {
        this.money += amount
    }

    fun earnMoney() {
        this.money += 0
    }
}
```

```kotlin
// Overloading.kt
fun main() {
    val cheater = Player(nickname = "noobs")

    fun Player.earnMoney(money: Int) {
        this.money += (money * 10)
    }

    println("\ncheater.earnMoney(10)")
    cheater.earnMoney(10)
    println(cheater.toPrettyString())

    fun Player.earnMoney() {
        this.money = Int.MAX_VALUE
    }

    println("\ncheater.earnMoney()")
    cheater.earnMoney()
    println(cheater.toPrettyString())

    fun Player.earnMoney(money: Double) {
        this.money += money.toInt()
    }

    println("\ncheater.earnMoney(Double.MAX_VALUE)")
    cheater.earnMoney(Double.MAX_VALUE)
    println(cheater.toPrettyString())
}
```

💡 Practice

```kotlin
// android branch
// TicTacToeViewModel.kt
class TicTacToeViewModel : ViewModel() {
    // ...
    
    fun play(x: Int, y: Int) {
        play(uiState.value.currentPlayer, x, y)
    }

    private fun play(player: Player, x: Int, y: Int) {
        // ...
    }
}
```