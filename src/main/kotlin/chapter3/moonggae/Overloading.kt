package chapter3.moonggae


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