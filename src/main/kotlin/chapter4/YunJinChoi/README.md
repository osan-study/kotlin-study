## 44. 람다

> 람다는 부가적인 장식이 덜들어간 함수다. 람다에는 이름이 없고, 함수 생성에 필요한 최소한이ㅡ
> 코드만 필요하며, 다른 코드에 람다를 직접 삽입하여 사용할 수 있다.

함수 본문은 하나 이상의 식이다, 식이 여럿인 경우 마지막 식이 람다의 결과가 된다 .

람다는를 사용하면 파라미터가 하나일 경우 코틀린은 자동으로 파라미터 이름을 `it`로 만든다.

```kotlin
fun main() {

    val list = listOf(1, 2, 3)
    list.map ({"[${it}]"})

    // 설명 아래 
    list.map {"[${it}]"}
}
```

함수의 파라미터가 람다뿐이라면 람다 주변의 괄호를  없앨 수 있으므로, 더 깔끔하게 코드를 적을 수 있다.

> 만약 람다가 너무 복잡하다면 이름 붙은 함수를 정의하는 편이 더 명확하다, 람다를 단 한번만 사용하더라도 람다가 너무 크다면 이름붙은 함수로 작성하는게 더 낫다.

---

## 45. 람다의 중요성

> filter, map 등 다양하게 직접 구현하지 않고 사용할 수 있는 다양한 기능들을 제공한다. 

대표적으로 `filter` 를 본다면 다음과 같다

> filter는 보존하고 싶은 원소를 선택하는 술어를 인자로 받는다 . 이 술어를 람다로 전달 가능하다.

```kotlin
fun main() {
    val list = listOf(1,2,3, 4)
    list.filter { it % 2 == 0 } // 출력 - [ 2, 4 ]
}
```

람다의 또 다른 특징으로 자신의 영역 밖에 있는 요소를 참조할 수 있는 능력이 있다.

함수가 자신이 속한 환경의 요소를 포획하고나 닫아버리는 것을 클로저라고 한다.

> 클로저와 람드는 서로 다른 개념이며 클로저가 없는 람다가 있을 수 있으며, 람다가 없는 클로저도 있을 수 있다.
> 
> 람다는 자신이 포획한 요소를 읽을수 있으며 또한 변경도 가능하다.

```kotlin
fun main() {
    val list = listOf(1, 2, 3, 4)
    var sum = 0;
    list.forEach { sum += it }
    println(sum) // 출력 결과 - 10
}
```

---

## 46. 컬렉션에 대한 연산

### 다양한 방식의 초기화 
```kotlin
List의 생성자중 첫번째는 크기, 두번째는 원소를 초기화하는 람다를 받는다.
fun main() {
    val case1 = List(10) {it}
    val case2 = List(10) {0}
    val case3 = List(10) { 'a' + it}
    val case4 = List(10) {list3[it % 3]}
}
```

다양한 컬렉션 함수가 제공하는 함수

`filter()` - 주어진 술어와 일치(true)하는 모든 원소가 들어있는 새로운 리스트를 반환
`any()` - 원소중 어느하나에 대해 술어가 true를 반환하면 true 반환 
`all()` - 모든 원소가 술어와 일치하는지 확인
`none()` - 술어와 일치하는 원소가 하나도 없는지 확인
`find()` - 술어와 일치하는 첫번째 원소 반환, 원서가 없다면 예외 발생, findOrNull은 없다면 null 반환
`lastOrNull()` - 술어와 일치하는 마지막 원소 반환, 일치하는 원소가 없다면 null 반환  
`count()` - 술어와 일치하는 원소의 갯수 반환 


`partition()` - List가 들어있는 Pair 객체를 만들며, 술어에 대한 true/false값에 대해서 Pair로 제공

---

## 47. 멤버참조

> 멤버 함수나 프로퍼티 이름 앞에 그들이 속한 클래스 이름과 2중콜론을 위치시켜서 멤버참조를 만든다.

```kotlin
data class Person(
    val name: String,
    val age: Int
)

fun main() {

    val persons = listOf(Person("YunNote", 32));

    val map = persons.map(Person::name)
    println(map) // [YunNote]
}
```

### 생성자 참조

> 클래스 이름을 사용하여 생성자에 대한 참조를 만들 수 있다.

```kotlin
data class Person(val id: Int, val name: String)

fun main() {

    val names = listOf("현빈", "원빈") 
    println(names.mapIndexed(::Person))
    // [Person(id=0, name=현빈), Person(id=1, name=원빈)]
}
```

함수와 생성자 참조를 사용하면 단순히 람다로 전달되기만 하는 코드에 대해서 수고하지 않아도 알아서 넣어주기때문에
람다를 사용할 때보다 더 가독성이 좋아지는 장점이 있다.

---

## 48. 고차함수 

> 프로그래밍언어에서 함수를 다른함수의 인자로 넘길 수 있거나 함수가 반환값으로
> 함수를 돌려줄 수있으면 언어가 고차함수를 지원한 다고 말한다.

지금까지 다룬 함수들 `filter()`, `map()`, `any()`등의 고차함수를 이미 사용하였다.

```kotlin

fun <T> calculate(a: T,b: T, function: (T, T) -> T) : T {

    return function(a,b)
}

fun main() {

    println(calculate(1,2 , { a, b -> a+b }))
    println(calculate(1,2) { a, b -> a*b } )
}

```

---

## 49. 리스트 조작하기

> zip()은 두 List의 원소를 하나씩 짝 짓는 방식으로 묶는다.

```kotlin

fun main() {
    val left = listOf("a", "b" , "c" ,"d")
    val right = listOf(1,2,3,4,5)
    
    println(left.zip(right))
    // 출력 결과 - [(a, 1), (b, 2), (c, 3), (d, 4)]
}
```

출력 결과를 보면 right의 값은 1~5 이지만 zip()을 통해 묵은것을 보면 4까지인것을 알 수 있다.

`zip()`은 두개의 시퀀스중 어느 한쪽이 끝나면 묶기 연산도 끝나게 된다.

추가로 `zipWithNext()`를 사용하면 어떤 원소와 해당 원소에 인접한 다음 원소를 묶을 수 있다.

```kotlin
fun main() {
    var right = listOf(1,2,3,4,5)

    println(right.zipWithNext())
    // 출력 결과 - [(1, 2), (2, 3), (3, 4), (4, 5)]
}
```

### 평평하게 하기 (flatten)

`flatten()`은 각 원소가 List인 List를 인자로 받아 원소가 따로따로 들어있는 List를 반환한다.

```kotlin
fun main() {
    val list = listOf(
        listOf(1,2),
        listOf(3,4)
    )
    
    println(list.flatten())
    // 출력결과 [1,2,3,4]
}
```

---

## 50. 맵만들기

> 내용은 대략 비슷해서.. 패스 ..

다만 해당 내용에서 두그룹으로 나누는 partition() 함수가 거 직접적이며, 결과 그룹이
세 개 이상인 경우 groupBy()를 사용하는것이 적합하다.

---

## 51. 시퀀스
