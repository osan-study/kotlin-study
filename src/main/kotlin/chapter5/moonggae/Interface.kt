package chapter5.moonggae

interface Job {
    val name: String
    var money: Int
    var salary: Int  // 각각 다른 override 방법

    fun work()

    fun upgrade() { // 정의된 함수 또한 재정의 가능
        if (money >= salary * 12) {
            money -= salary * 12
            salary = (salary * 1.2).toInt()
        }
    }
}

class Wizard(
    override val name: String,
    override var money: Int,
    override var salary: Int
) : Job {
    override fun work() {
        println("$name: Reducto!")
        money += salary
        upgrade()
    }
}

class HouseElf(
    override val name: String,
    override var money: Int
) : Job {
    override var salary: Int
        get() = 0
        set(_) {}

    override fun work() {
        println("$name: save harry potter")
        money += salary
        upgrade()
    }
}

class Developer(
    override val name: String,
    override var money: Int,
) : Job {
    override var salary: Int = 1_000

    override fun work() {
        println("$name: code something..")
        money += salary
        upgrade()
    }

    override fun upgrade() {
        if (money >= salary * 20) {
            salary = (salary * 1.2).toInt()
        }
    }
}

fun main() {
    val workers = listOf(
        Wizard("harry", 0, 10_000),
        HouseElf("dobby", 0),
        Developer("minsu", 10_000)
    )

    repeat(20) {
        workers.forEach {
            it.work()
            println("money: ${it.money}")
            println("salary: ${it.salary}\n")
        }
    }
}