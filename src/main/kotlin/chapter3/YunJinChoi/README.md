
## 👊 30. 확장함수 
> 확장 함수는 기존 클래스에 멤버 함수를 추가하는 것과 같은 효과를 낸다. 확장할 대상 타입은 수신객체 타입 이라고 한다.
> 
> 확장 함수를 정의하기 위해서는 함수이름 앞에 수신 객체 타입을 선언한다.
> 
> [확장함수 샘플](./Sample/ExtensionFunction.kt)

```kotlin
fun 수신타입.확장함수 () {...} 와 같이 표기한다 
```

위와 같이 작성한다면 확장함수를 마치 수신 객체 타입의 멤버함수인 것처럼 호출 할 수 있다.

추가로 `this` 키워드를 사용하여 멤버 함수나 다른 확장함수에 접근 가능하다. 생략도 할 수 있기 때문에
명시적으로 멤버를 한정시킬 필요는 없다.

주의해야할 점은 확장 함수는 수신객체타입의 `public` 원소에만 접근할 수 있ㄷ.
따라서 일반 함수가 할 수 있는 일만 처리 가능하다.

[확장함수 public/private 코드](./Sample/ExtensionFunction2.kt)

---

## 👊 31. 이름 붙은 인자와 디폴트 인자

> 함수를 호출하면서 이름을 지정할 수 있다.
> 
> 이름 붙은 인자를 사용하면 코드 가독성이 좋아지며, 문서를 살펴보지 않고도
> 코드를 쉽게 이해할 수 있다.
> 
> [샘플 코드](./Sample/NamedArguments.kt)

이름 붙은 인자와 일반 인자의 위치를 섞어서도 사용가능하며 만약 순서를 변경한다면 인자 목록의
나머지 부분에서도 이름 붙은 인자를 사용해야 한다.

이유는 순서가 변경되면 컴파일러가 생략된 인자들의 위치를 알 수 없기 때문이다. 

`이름 붙은 인자` 와 함께 자주쓰는 방법은 `디폴트 인자` 이다. 디폴트 인자는 파라미터의
디폴트 값을 지정하여 해당 값이 들어오지 않을 경우 선언된 디폴트 값으로 대체한다.

> [이름 붙은 인자 + 디폴트 인자 코드 샘플](./Sample/DefaultArgument.kt)

---

## 👊 32. 오버로딩 

> 오버로딩이란 하나의 함수나 연산자를 여러가지 방식으로 동작하도록 만드는 기술을 의미한다.

코틀린의 함수 시그니처는 함수이름, 파라미터 목록, 반환타입으로 이뤄지며 시그니처를 비교하여
함수와 함수를 구분한다. 

함수를 오버로딩 할때는 파리미터 리스트를 서로다르게 만들어야 한다. 반환타입은 오버로딩의 대상이 아니다.

> 주의해야할 점은 멤버함수와 확장함수의 우선순위 이다.
> 
> 코틀린에서는 시그니처가 똑같은 확장함수와 멤버함수가 있다면 확장함수보다 멤버함수를 우선시하며, 멤버변수를 기준으로 확장함수를 오버로딩할 수 있다. 


```kotlin
// sample
// Bad
fun addInt(a: Int, b: Int) = a + b;
fun addDouble(a: Double, b: Double) = a + b;

// Good
fun add(a: Int, b: Int) = a + b;
fun add(a: Double, b: Double) = a + b;
```

오버로딩의 장점은 위와 같이 `같은 주제를 다르게 변경한다`는 개념을 더 명확하게 표현할 수 있다. 또한
단순성을 얻을 수 있어 보다 더 읽기 좋은 코드를 작성할 수 있게 되며, 추상화 수준을 높이고, 불필요한 중복을 줄여주기도 한다.

---

## 👊 33. When 식

 > when 식은 어떤 값을 여러가지 가능성과 비교하여 서낵할 때 주로 사용한다.
> 
> [when 식 Sample](./Sample/WhenOrd.kt)

위의 샘플과 같이 사용하면 if문 여러개를 중첩한것처럼 사용 가능.

다만 else키워드가 없다면 컴파일 타입오류가 발생한다. 이 오류는 when이 모든 경우를 
처리해야 하기 때문에 else를 추가하라는 에러가 발생한다.

다만 when을 식처럼 사용하지 않고 문처럼 취급하는 경우 else를 사용하지 않아도 된다. 

when의 조건에는 꼭 상수가 아니여도 아무값이나 와도 된다.

> 만약 when식과 if식이 있다면 when이 더 유연하기 때문에 선택의 여지가 있다면 when 사용을 권장한다.

추가로 when에 조건식을 포함히자 않는 경우가 있는데 이럴때는 왼쪽식에 항상 Boolean에 해당하는 값을 넣어야 한다.
[when 인자 없는 샘플](./Sample/WhenNot.kt)

---

## 👊 34. 이넘 

```kotlin
enum class Level {
    HIGH, MEDIUM, LOW, EMPTY
}
```

enum을 생성하며 enum에 해당하는 문자열을 반환하는 toString()이 생성된다.

import하여 `Level.HIGH` 대신 `HIGH`와 같이 직접 사용 가능하다 .  

enum은 코드의 가독성을 높여주기 때문에 필요시 사용하는것을 권장한다

---

## 👊 35. 데이터 클래스 

> class 의 사용은 값을 의미있게 묶어주거나 사용할 수 있게 도와준다. 하지만 데이터만 저장하는게
> 목적인 경우 반복적인 코드를 많이 작성해야한다.
> 
> Kotlin에서는 이러한 문제를 해결하기 위해 data 키워드를 통해 data 클래스를 지원한다.

```kotlin
data class Sample (val arg1: String, var arg2: String)

fun main() {
    val sample: Sample = Sample("HELLO", "WORLD");
    print(sample); // output - Sample(arg1=HELLO, arg2=WORLD) 
}
```

data class 는 toString()을 작성하지 않아도 객체를 더 읽기 쉽고 보기 좋은형식으로 표현해준다.

또한 equals()가 자동으로 생성되며 해당 함수는 생성자 파라미터에 열거된 모든 프로퍼티가 같은지 
검새하는 식으로 구현된다.

```kotlin
class Person (val name:String)
// Person("HELLO") != Person("HELLO") 같지 않음

data class Person (val name:String)
// Person("HELLO") ==  Person("HELLO") 같음.
```

> 모든 data 클래스에 생성되는 유용한 메서드로는 copy()가 있다. copy()는 객체의 모든 데이터를
> 포함하는 새 객체를 생성해주며, 파라미터의 이름은 생성자 파라미터에 열거된 일므과 같다.
> 
> 모든 인자는 각 프로퍼티의 현재 값으로 지정되어있으며 변경하고자 하는 값만 이름 붙은 인자로 지정하여
> 변경할 수 있다.

---

## 👊 36. 구조분해선언 

> 여러 값이 들어있는 값에 대해서 식별자를 동시에 선언하면서 초기화 가능 

기본적으로 data class 는 구조분해 할당을 지원한다.

data class의 코틀린 바이트 코드를 보면 `component1`, `component2`와 같이 선언된 필드 갯수만큼 생성됩니다.

```kotlin
// component1(), component2(), component3() 과 같이 3개 생성 
data class Sample(val a: Int, val b: String, val c:Int)

Pair는 기본적으로 data class 로 구성되어있어 내부적으로 component1(), component2() 가 생성된다
```
그렇다면 일반 class는 구조분해 할당이 불가능한가?

일반 class에서 사용하는 방법은 다음과 같다

```kotlin
class Sample(val a: Int, val b: String) {
    
    // operator 를 직접 구현하여 구조분해할당 사용 가능.
    operator fun component1() = a;
    operator fun component2() = b;
}
```

---

## 👊 37. 널이 될 수 있는 타입 

```kotlin

fun main() {
    // Null 대입 불가
    val 널_대입_불가 :String = null;
    
    val 널_대입_가능: String? = null;
}
```

타입 이름 뒤에 물음표(?)를 붙여 결과가 null이 될 수 있음을 표시할 수 있다.

```kotlin
fun main() {
    val hello: String? = "HELLO"
    
    // NullPointerException이 발생 할 수 있어 컴파일 불가
    hello.length
    
    // 사용 위해서는 null에 대한 검사를 해야한다.
    if(hello != null) {
        hello.length;
    }
}
```
위의 코드와 같이 명시적으로 if 검사를 통해 null 체크를 하게 되면 코틀린이 해당 객체를
참고하도록 허용해 준다.

하지만 매번 이렇게 if를 통해 검사하게되면 중복코드와함께 매번 번거로운 작업이 된다. 

---

## 👊 38. 안전한 호출과 엘비스 연산자

> Null이 될 수 있는 타입에는 여러 제약이 가해진다. 예를 들면 아래와 같다.

```kotlin
fun main() {
    
    val name: String? = "HELLO";
    
    // name 이 null이 될 수 있어 컴파일 시점에 에러 발생 
    name.length
}
```
length를 사용하기 위해서는 매번 if를 통한 Null체크를 진행하였다 코틀린에서는 이러한 문제를 해결하기 위해
null이 아닐때만 연산을 수행할 수 있는 안전한 호출을 제공한다.

위 코드를 바꾸면 아래와 같다 

```kotlin
fun main() {
    
    val name: String? = "HELLO";
    
    // ?. 를 통한 호출  
    name?.length
}
```

상당수의 프로그래밍 언어에서는 엘비스 연산자와 같은 널 복합 연산자를 제공한다 .

```kotlin
//kotlin
val name = null ?: "hello" 

// Java 
String name = Optional.ofNullable(null).orElseGet(() -> "hello");
String name = StringUtils.defaultString(null, "hello");
```
코틀린의 엘비스 연산자는 `?:` 키워드 기준으로 좌측의 값이 null이라면 오른쪽의 값이 기본값이 된다.

---

## 👊 39. 널 아님 단언 

> null이 될 수 없다고 주장하기 위해 느낌표 두개 `!!`를 사용한다. 이를 널 아님 단언이라고 한다.

```kotlin
fun main() {
    
    var name: String? = "Hello";

    // val name2: String = name;
    val name2: String = name!!;
}
```
일반적으로 `!!`를 그냥 쓰는 경우는 없고 대부분 역참조화 함께 쓴다.
```kotlin

val name: String? = "Hello";

name!!.length;
```

다만 널 아님 단언 (!!)을 사용하지 않고 안전한 호출이나 명시적인 null 체크를 통해
검사를 활용하는것을 권장한다. 또한 코드에서 !!를 자주 사용한다면
적절한 단언과 함께 함수를 분리하는 것이 좋다. 

---

## 👊 40. 확장 함수와 널이 될 수 있는 타입

```kotlin
fun main() {
    val name: String? = null;
    name.isNullOrBlank()
}
```

null이 허용되는 name필드 인데 왜 안전한 호출을 사용하지 않고 호출이 가능할까요

이유는 null이 될 수 있는 타입인 String?에 확장함수로 정의되어 있기 때문입니다.

예를 들면 아래와 같습니다

```kotlin

fun String?.isCustomNullOrEmpty() : Boolean = 
    this == null || isEMpty()

fun main() {
    "".isCustomNullOrEmpty()
}
```

---

## 👊 41. 제네릭스 소개 

제네릭 타입을 정의하라면 클래스 이름 뒤에 부등호(<>)를 통해 타입을 지정한다.

```kotlin
// 꼭 T가 아니어도 된다. 의미만 ..
class GenericTest<T> (private val value: T) {
    
    fun getValue(): T = value;
}
```

유니버셜 타입을 활용한 해결 , 유니버셜 타입은 모든 타입의 부모타입을 의미하며 Kotlin에서 Any가 유니버셜 타입이다.

```kotlin
// 꼭 T가 아니어도 된다. 의미만 ..
class GenericTest (private val value: Any) {
    
    fun getValue(): Any = value;
}
```

Any를 사요하면 모든 타입에 대해서 동작하겠지만 구체적인 타입이 필요해지면
정상적으로 동작하지 않는다.

---

## 👊 42. 확장 프로퍼티 

> 확장 프로퍼티에는 커스텀 게터가 필요하다. 확장 프로퍼티는 접근할 때마다 값이 계산된다.
> 
> 확장프로퍼티는 주로 기존 클래스에 프로퍼티가 추가 필요한 경우. 이미 정의된 클래스가 있다면 추가하고싶을때 유용하며. 
> 데이터 변환을 위한 읽기전용 프로퍼티를 정의할떄 유용하다.
> 
> 확장함수는 동일하게 기존 클래스에 메서드 추가가 필요한 경우, 유틸리티 함수로써의 사용에 용이하다.
> 
> 두가지 방식다 기존 클래스의 코드를 수정하지 않고 새로운 기능을 추가가능하며, 확장성과 유지보수성을 높이는데 도움된다.
> 
> 해당 방식은 자바의 interface default와 얼추 비슷하겠지만 사용 목적과 방식은 다르다.
> 
> Java는 기본 구현의 제공 Kotlin에서는 확장입니다.

```kotlin
val String.확장프로퍼티 : IntRange
    get() = 0 until length;

fun main() {

    val 확장프로퍼티 = "헬로우".확장프로퍼티
    print(확장프로퍼티)
    // output - 0..2 
}
```

확장 프로퍼티는 매번 값이 계산되기 때문에 기능이 단순하고 가독성을 향상 시키는 경우에만 프로퍼티를 권장한다.