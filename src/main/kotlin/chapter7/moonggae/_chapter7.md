# Chapter 7

### 확장 람다
- 일반 람다와 확장 함수의 특성을 결합

```kotlin
val va: (String, Int) -> String = { str, n ->
    str.repeat(n) + str.repeat(n)
}

val vb: String.(Int) -> String = {
    this.repeat(it) + repeat(it)
}
```
- `va`는 일반 람다, `vb`는 확장 람다
- 확장 람다에서 `this`는 수신 객체를 참조

```kotlin
// 파라미터와 사용
val zero: Int.() -> Boolean = { this == 0 }
val one: Int.(Int) -> Boolean = { this % it == 0 }
val two: Int.(Int, Int) -> Boolean = { arg1, arg2 ->
    this % (arg1 + arg2) == 0
}
```
- 파라미터 개수에 따라 다양한 형태로 정의 가능
- 수신 객체 타입을 명시적으로 지정

```kotlin
// 함수 파라미터로서의 확장 람다
fun f1(lambda: (A, B) -> Int) = lambda(A(), B())
fun f2(lambda: A.(B) -> Int) = A().lambda(B())
```
- 일반 람다와 확장 람다를 함수 파라미터로 사용 가능

```kotlin
// 반환 값 처리
fun unitReturn(lambda: A.() -> Unit) = A().lambda()
fun nonUnitReturn(lambda: A.() -> String) = A().lambda()
```
- Unit을 반환하는 람다와 특정 타입을 반환하는 람다 구분

```kotlin
// 변환 함수 예제
fun String.transform1(n: Int, lambda: (String, Int) -> String) = lambda(this, n)
fun String.transform2(n: Int, lambda: String.(Int) -> String) = lambda(this, n)
```
- 일반 람다와 확장 람다를 사용한 변환 함수 비교

```kotlin
// 함수 참조와 확장 람다
fun Int.d1(f: (Int) -> Int) = f(this) * 10
fun Int.d2(f: Int.() -> Int) = f() * 10
```
- 함수 참조를 확장 람다로 사용 가능

```kotlin
// 다형성과 확장 람다
open class Base {
    open fun f() = 1
}
class Derived : Base() {
    override fun f() = 99
}
fun Base.g() = f()
fun Base.h(xl: Base.() -> Int) = xl()
```
- 확장 람다는 동적 디스패치 지원

```kotlin
// 익명 함수로서의 확장 람다
exec(10, 2, fun Int.(d: Int): Boolean {
    return this % d == 0
})
```
- 익명 함수 구문으로 확장 람다 정의 가능

```kotlin
// 문자열 생성에서의 활용
private fun clean() = buildString {
    append("ABCs: ")
    ('a'..'x').forEach { append(it) }
}
```
- `buildString`은 확장 람다를 활용한 대표적인 예

```kotlin
// 컬렉션 빌더에서의 활용
val characters: List<String> = buildList {
    add("Chars:")
    ('a'..'d').forEach { add("$it") }
}
```
- `buildList`, `buildMap` 등에서 확장 람다 활용

<br/>

`DSL (Domain-Specific Language)`
- DSL은 특정 도메인이나 문제 영역에 특화된 언어
- 해당 도메인의 전문가들이 쉽게 이해하고 사용할 수 있도록 설계됨
- 일반 프로그래밍 언어보다 표현력이 높고 간결함

장점
1. 가독성 향상: 도메인 전문가도 코드를 쉽게 읽고 이해할 수 있음
2. 생산성 증가: 특정 작업을 위한 간결하고 직관적인 문법 제공
3. 오류 감소: 도메인 규칙을 언어 차원에서 강제할 수 있음

코틀린에서의 DSL
- 코틀린의 여러 기능(확장 함수, 연산자 오버로딩, 중위 표기법 등)을 활용해 강력한 DSL 구축 가능
- 특히 확장 람다는 DSL 구축에 매우 유용한 도구

<br/>

DSL 구축 예제: 샌드위치 레시피

```kotlin
fun sandwich(
    fillings: Sandwich.() -> Unit
): Sandwich {
    val sandwich = Sandwich()
    sandwich.add(Bread())
    sandwich.toast()
    sandwich.fillings()
    sandwich.cut()
    return sandwich
}

// 사용 예
val pbj = sandwich {
    add(PeanutButter())
    add(GrapeJelly())
}

val hamAndSwiss = sandwich {
    add(Ham())
    add(Swiss())
    add(Mustard())
    grill()
}
```

- `sandwich` 함수는 `Sandwich` 객체의 확장 람다를 받아 샌드위치 만드는 과정을 표현
- 이 DSL을 사용하면 샌드위치 레시피를 매우 직관적이고 읽기 쉬운 방식으로 작성 가능
- 확장 람다를 통해 `Sandwich` 객체의 컨텍스트 내에서 작업할 수 있어, `this`나 수신자 객체 타입을 명시적으로 참조할 필요가 없음

<br/>

DSL 구축 시 확장 람다의 이점
1. 컨텍스트 제공: 수신자 객체의 메서드와 프로퍼티에 직접 접근 가능
2. 가독성: 불필요한 구문을 줄이고 도메인 용어에 집중할 수 있음
3. 타입 안전성: 컴파일 시점에 타입 검사가 이루어져 안전한 DSL 구축 가능
4. 확장성: 기존 클래스를 수정하지 않고도 새로운 동작을 추가할 수 있음

<br/>

결론
- 확장 람다는 코드의 가독성과 표현력을 높임
- 함수형 프로그래밍과 객체 지향 프로그래밍의 장점을 결합
- DSL 구축에 매우 유용한 도구로, 도메인 특화 언어를 만들어 복잡한 로직을 간결하고 이해하기 쉬운 형태로 표현 가능
- 코틀린의 이러한 기능들은 더 유지보수하기 쉽고, 도메인 전문가와 개발자 간의 소통을 원활하게 하는 코드 작성을 가능하게 함


### 스코프 함수
- 코드 가독성을 위해 사용

|               | this          | it     |
|---------------|---------------|--------|
| 마지막 식의 값을 돌려줌 | `run`, `with` | `let`  |
| 수신 객체를 돌려줌    | `apply`       | `also` |

- `?.`을 사용해 `null`인 경우 생략하기 용이

```kotlin
class Gnome(val name: String) {
    fun who() = "Gnome: $name"
}

fun whatGnome(gnome: Gnome?) {
    gnome?.let { it.who() }     
    gnome?.run { who() }        
    gnome?.apply { who() }      
    gnome?.also { it.who() }    
    // null 인지 판단 할 수 없음
    with(gnome) { this?.who() }
}
```
- 스코프 함수는 `use()`와 비슷한 자원 해제를 제공하지 못한다.
- `use()`는 람다에서 반환할 수 없다.


`inline 함수`
- 컴파일시 함수 본문 코드가 삽입되는 함수로, 바이트코드는 늘어나지만 성능이 좋아짐
- 함수 본문이 클경우 비효율 적임
- 파라미터를 다른 함수로 전달하거나 다른 곳에서 참조할 수 없음
- 스코프 함수는 인라인됨