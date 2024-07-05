# Chapter4

### 44. Lambda

1. Lambda: 최소한의 코드로 이루어진 이름 없는 함수
2. 식이 여럿인 경우 마지막 식이 람다의 결과
3. 파라미터가 하나일 경우 `it`으로 사용, 파라미터 이름 정의 필요 x
4. 람다가 함수의 마지막 파라미터인 경우 `{}`로 함수의 괄호 대체 가능
5. 람다의 파라미터가 여러개인 경우 파라미터 이름 정의 필요, 파라미터를 사용하지 않을경우 `_`로 대체 가능
6. 람다에 파라미터가 없을 경우 `->` 사용하지 않는것을 권장

```kotlin
fun main() {
    val text = "`mcqnhc"
    val newText = text.map { // [4]
        val textChar: Char = it // [3]
        textChar + 1 // [2]
    }

    newText.mapIndexed { _, c -> // [5]
        print(c)
    }
}
```


### 45. 람다의 중요성
1. `Collection`에서 제공하는 함수를 통해 `Iteration`을 직접 처리할 필요 없이 간결하고 명확한 코드를 작성할 수 있다.
2. 람다를 변수에 담아 재사용할 수 있다.
3. `클로저(closure)`를 지원해 람다 밖에 있는 변수에 접근할 수 있다.

```kotlin
var sumResult: Int? = null

fun main() {
    val addNumbers: (Int) -> Unit = { sumResult = (sumResult ?: 0) + it } // [2], [3]
    val isEven: (Int) -> Boolean = { it % 2 == 0 }
    (1..10)
        .filter(isEven)
        .forEach(addNumbers)
    
    println(sumResult)
}
```


### 46. 컬렉션에 대한 연산
[코드 참조](Collection.kt)

### 47. 멤버 참조
- `::`를 이용해 멤버를 참조하여 람다를 대신할 수 있다.

```kotlin
fun memberReferences() {
    println("chickenList.filter(Chicken::isFavorite):")
    println(chickenList.filter(Chicken::isFavorite).toPrettyString())

    println("chickenList.sortedWith(compareBy(Chicken::isFavorite, Chicken::price)):")
    println(chickenList.sortedWith(compareBy(Chicken::isFavorite, Chicken::price)).toPrettyString())
}
```

- 함수도 참조할 수 있다.
```kotlin
fun functionReferences() {
    println("chickenList.filter(Chicken::isRed).map { it.name }: ${chickenList.filter(Chicken::isRed).map { it.name }}")
}
```

- 생성자도 참조할 수 있다.
```kotlin
fun constructorReference() {
    data class Student(
        val id: Int,
        val name: String
    )

    val names = listOf("Alice", "Bob")
    val students = names.mapIndexed { index, name ->
        Student(index, name)
    }

    println(students)
    println(names.mapIndexed(::Student))
}
```

- 확장함수도 참조할 수 있다.
```kotlin
fun Int.times47() = times(47)

class Frog
fun Frog.speak() = "Ribbit!"

fun goInt(n: Int, g: (Int) -> Int) = g(n)

fun goFrog(frog: Frog, g: (Frog) -> String) =
  g(frog)

fun main() {
  goInt(12, Int::times47) eq 564
  goFrog(Frog(), Frog::speak) eq "Ribbit!"
}
```


### 48. 고차 함수
- 함수를 인자로 넘기는 것을 말함
- nullable 타입을 정의할 때 리턴 타입과 함수 전체의 null 여부 구분 주의

```kotlin
// any
public inline fun <T> Iterable<T>.any(predicate: (T) -> Boolean): Boolean {
    if (this is Collection && isEmpty()) return false
    for (element in this) if (predicate(element)) return true
    return false
}
```

```kotlin
// repeat
public inline fun repeat(times: Int, action: (Int) -> Unit) {
    contract { callsInPlace(action) }

    for (index in 0 until times) {
        action(index)
    }
}
```


## 49. 리스트 조작하기
- `zip()`으로 리스트를 짝지어 묶는다.
- 만들어진 pair로 람다 연산을 할 수 있다.
- `zipWithNext()`로 인접한 원소를 묶는다.

```kotlin
fun zipper() {
    val girls = listOf("수진", "혜진", "지연")
    val boys = listOf("민준", "지훈", "재현", "승우")

    println(girls)
    println(boys)
    println("girls.zip(boys): ${girls.zip(boys)}")
}
```
```kotlin
fun zipAndTransform() {
    val names = listOf("후라이드", "양념", "반반", "다리콤보", "날개콤보")
    val prices = listOf(10_000, 11_000, 11_500)

    val cheapChickens = names.zip(prices, ::Chicken)
    println("cheapChickens: $cheapChickens")

    println("names.zipWithNext(): ${names.zipWithNext()}")
}
```

- `flatten()`은 List안에 있는 List를 1차원으로 나열한다.
- `map().flatten()`은 `flatMap()`으로 사용할 수 있다.
```kotlin
fun flatten() {
    val list = listOf(
        listOf(1, 2),
        listOf(4, 5),
        listOf(7, 8),
    )

    println("list.flatten(): ${list.flatten()}")
}
```

```kotlin
fun flatMap() {
    class Book(
        val title: String,
        val authors: List<String>
    )

    val books = listOf(
        Book("1984", listOf("George Orwell")),
        Book("Ulysses", listOf("James Joyce"))
    )
    println("books.map { it.authors }.flatten(): ${books.map { it.authors }.flatten()}")
    println("books.flatMap { it.authors }: ${books.flatMap { it.authors }}")
}
```

### 50. Map
- `groupBy()`를 이용해 Map을 만들 수 있다.
  - 파라미터로 키 값을 전달한다.

```kotlin
fun groupBy() {
    val map: Map<Int, List<Person>> = people.groupBy(Person::age)
    println("map:")
    println(map)
}
```

- `associateWith()`을 이용해 리스트 원소를 `key`로 하고 파라미터 람다의 리턴 값을 `value`로 하는 map을 만들 수 있다.
```kotlin
fun associateWith() {
    val map = people.associateWith { it.name }
    println("map:")
    println(map)
}
```
- `associateBy()`는 `key`, `value`가 반대
<br /><br /><br />
- get
```kotlin
fun main() {
  val map = mapOf(1 to "one", 2 to "two")
  map.getOrElse(0) { "zero" } eq "zero"

  val mutableMap = map.toMutableMap()
  mutableMap.getOrPut(0) { "zero" } eq "zero"
  mutableMap eq "{1=one, 2=two, 0=zero}"
}
```

- filter
```kotlin
fun main() {
  val map = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")

  map.filterKeys { it % 2 == 1 } eq "{1=one, 3=three}"

  map.filterValues { it.contains('o') } eq "{1=one, 2=two, 4=four}"

  map.filter { entry ->
    entry.key % 2 == 1 && entry.value.contains('o')
  } eq "{1=one}"
}
```

- 연산 (map, mapKeys, mapValues, any, all, maxByOrNull, etc)
```kotlin
fun main() {
    val even = mapOf(2 to "two", 4 to "four")

    even.map { "${it.key}=${it.value}" } eq listOf("2=two", "4=four")

    even.map { (key, value) -> "$key=$value" } eq listOf("2=two", "4=four")

    even.mapKeys { (num, _) -> -num }
        .mapValues { (_, str) -> "minus $str" } eq
            mapOf(-2 to "minus two",
                -4 to "minus four")

    even.map { (key, value) ->
        -key to "minus $value"
    }.toMap() eq mapOf(-2 to "minus two",
        -4 to "minus four")
}
```


### 51. 시퀀스
- List: 즉시(eagerly) 계산 - 수평적 평가
  - 모든 연산을 list 원소에 적용
- Sequences: 지연 계산 - 수직적 평가
  - 결과가 필요할 때만 계산을 수행

- 중간 연산은 결과로 다른 `Sequence`를 반환 한다.
- 최종 연산을 값으로 내놓는다.
```kotlin
fun eagerVsLazyEvaluation() {
    fun Int.isEven(): Boolean {
        println("$this.isEven()")
        return this % 2 == 0
    }

    fun Int.square(): Int {
        println("$this.square()")
        return this * this
    }

    fun Int.lessThanTen(): Boolean {
        println("$this.lessThanTen()")
        return this < 10
    }

    val list = listOf(1, 2, 3, 4)
    println("list >>")
    list
        .filter(Int::isEven)
        .map(Int::square)
        .any(Int::lessThanTen)

    println("asSequence >>")
    list.asSequence()
        .filter(Int::isEven)
        .map(Int::square)
        .any(Int::lessThanTen)
}
```

- `generateSequence()`을 이용해 시퀀스를 만들 수 있음
```kotlin
fun generateSequence1() {
    val naturalNumbers = generateSequence(1) { it + 1 }
    println("naturalNumbers.take(3).toList(): ${naturalNumbers.take(3).toList()}")
    println("naturalNumbers.take(10).sum(): ${naturalNumbers.take(10).sum()}")
}
```
```kotlin
fun generateSequence2() {
    val items = mutableListOf(
        "first", "second", "third", "XXX", "4th"
    )
    val seq = generateSequence {
        items.removeAt(0).takeIf { it != "XXX" } // null 반환시 종료
    }

    println("seq.toList(): ${seq.toList()}")
}
```

- 시퀀스는 한 번만 이터레이션 할 수 있다?
```kotlin
fun numberSequence() {
    val seq = generateSequence(6) { current ->
        (current - 1).takeIf { it > 0 }
    }

    println(seq.toList())
    println(seq.toList())
}
```


### 52. 지역 함수
- 함수 안에 정의된 함수
- 지역 확장 함수를 사용할 수 있다.
- 지역 함수를 참조할 수 있다.
- 람다가 복잡할경우 익명함수, 지역함수로 대체하기

### 레이블
- 람다를 제외한 함수에서 `return`할 구간을 지정
- `이름@`을 사용해 새 레이블을 만들 수 있음

```kotlin
private fun observePlaybackState() {
    viewModelScope.launch {
        playbackStateManager.flow.collect { playbackState ->
            _playerUiState.update {
                if (it is PlayerUiState.Loading) return@update it

                // ...
            }
        }
    }
}
```

### 지역 함수 조작하기
[예제 참조](LocalFunctions.kt)


### 53. 리스트 접기
```kotlin
fun main() {
  val chars = "A B C D E".split(" ")

  val fold = chars.fold("*") { acc, e -> "$acc $e" }
  println("fold: $fold")

  val foldRight = chars.foldRight("*") { e, acc -> "$acc $e" }
  println("foldRight: $foldRight")

  val reduce = chars.reduce { acc, e -> "$acc $e" }
  println("reduce: $reduce")

  val reduceRight = chars.reduceRight { e, acc -> "$acc $e" }
  println("reduceRight: $reduceRight")

  val runningFold = chars.runningFold("*") { acc, e -> "$acc $e" }
  println("runningFold: $runningFold")

  val runningReduce = chars.runningReduce { acc, e -> "$acc $e" }
  println("runningReduce: $runningReduce")
}
```


### 54. 재귀
- 함수 안에서 함수 자신을 호출
- 재귀 함수는 이전 재귀 함수 호출의 결과를 이용

```kotlin
fun runFactorial() {
    fun factorial(n: Long): Long {
        if (n <= 1) return 1
        return n * factorial(n - 1)
    }
    
    println("factorial(3): ${factorial(3)}")
    println("factorial(10): ${factorial(10)}")
}
```
- 재귀 함수가 끝없이 호출될 경우 `StackOverflowError` 발생
- `tailrec` 키워드를 이용해 꼬리 재귀 사용 
  - 호출 스택 하나로 줄어듬
  - 재귀가 마지막 연산이어야 함

```kotlin
fun fibonacci(n: Int): Long {
  tailrec fun fibonacci(
    n: Int,
    current: Long,
    next: Long
  ): Long {
    if (n == 0) return current
    return fibonacci(
      n - 1, next, current + next)
  }
  return fibonacci(n, 0L, 1L)
}

fun main() {
  (0..8).map { fibonacci(it) } eq
    "[0, 1, 1, 2, 3, 5, 8, 13, 21]"
  fibonacci(22) eq 17711
  fibonacci(50) eq 12586269025
}
```