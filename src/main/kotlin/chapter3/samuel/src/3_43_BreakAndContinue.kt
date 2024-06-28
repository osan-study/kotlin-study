fun main() {
    val nums = mutableListOf(0)
    for(i in 4 until 100 step 4){
        if(i == 8) continue
        if(i == 40) break
        nums.add(i)
    }
    println("nums: $nums")

    val strings = mutableListOf<String>()
    outer@ for(c in 'a'..'e') {
        for(i in 1..9) {
            if (i == 5) continue@outer
            if ("$c$i" == "c3") break@outer
            strings.add("$c$i")
        }
    }
    println("strings: $strings")
}