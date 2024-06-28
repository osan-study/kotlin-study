# 43 break와 continue

## break와 continue
루프 내에서 break (루프 루프 종료위치로 이동(탈출)), continue (해당 루프 시작위치로 이동)  
레이블을 통해 중첩 루프에서 원하는 루프까지 이동이 가능  
레이블은 <b>name@</b> 으로 선언

```kotlin
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

==result
nums: [0, 4, 12, 16, 20, 24, 28, 32, 36]
strings: [a1, a2, a3, a4, b1, b2, b3, b4, c1, c2]
```
