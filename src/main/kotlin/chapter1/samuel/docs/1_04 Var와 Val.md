# 04 Var와 Val

## 식별자
 - var: 변할 수 있는 수(variable), 재대입 가능
 - val: 값(value), 단 한번만 초기화 가능, 변경 불가

※ 식별자는 대소문자 구분을 하기 때문에 변수명에 유의할 것 ( 예시: Samuel != samuel )

```kotlin
var 식별자 = 초기화
val 식별자 = 초기화
```

```kotlin
fun atom1.main() {
    var whole = 11
    var fractional = 1.4
    var words = "Twas Brilling"
    println(whole)
    println(fractional)
    println(words)
}

== result
11
1.4
Twas Brilling
```
```kotlin
fun atom1.main() {
    var sum = 1
    sum = sum + 2
    sum += 3
    println(sum)
}

== result
6
```
```kotlin
fun atom1.main() {
    val whole = 11
    val fractional = 1.4
    val words = "Twas Brilling"
    println(whole)
    println(fractional)
    println(words)
}

== result
11
1.4
Twas Brilling
```

### 코틀린 네이밍 룰
관련링크: [https://kotlinlang.org/docs/coding-conventions.html#horizontal-whitespace](https://kotlinlang.org/docs/coding-conventions.html#horizontal-whitespace)
#### 클래스, 오브젝트 = PascalCase
```kotlin
open class DeclarationProcessor { /*...*/ }

object EmptyDeclarationProcessor : DeclarationProcessor() { /*...*/ }
```

#### 함수, 변수 = camelCase (※ 팩토리 함수는 예외적으로 Pascal case 일 수 있음)
```kotlin
fun processDeclarations() { /*...*/ }
var declarationCount = 1

// 예외
interface Foo { /*...*/ }
class FooImpl : Foo { /*...*/ }
fun Foo(): Foo { return FooImpl() }
```

#### 상수 = SCREAMING_SNAKE_CASE
```kotlin
const val MAX_COUNT = 8
val USER_NAME_FIELD = "Samuel"
```
