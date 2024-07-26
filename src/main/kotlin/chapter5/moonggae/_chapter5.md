# Chapter5

### Interface

- `class`가 구현해야할 의 멤버와 멤버 함수를 제시
- `class`에서 `override`키워드를 이용해 구현

[코드 참조](Interface.kt)

### 단일 추상 메서드(Single Abstract Method)

- 멤버 함수 하나만 있는 `interface`
- 람다를 이용해 구현 가능
- 파라미터로 사용 가능

[코드 참조](SAM.kt)

### Init

- `init`블록을 통해 `class`생성시 필요한 작업을 수행
- `init` 여러개 사용 가능, 정의한 순서대로 실행

[코드 참조](Init.kt)

### Constructor

- 주생성자(primary constructor): 생성자 파라미터 목록 + `init`
- 부생성자(secondary constructor): 생성자 오버로드
    - 다른 생성자와 다른 파라미터 목록
    - `this`를 통해 다른 생성자 호출
- 정의 및 호출 순서 유의

[코드 참조](Constuctor.kt)

### Inheritance

- 기존 `class`재사용 하기
- `open`키워드를 통해 상속 허용 (`final`이 default)
- 관계 표현

| 기존 class             | 새로운 class             |
|----------------------|-----------------------|
| 기반 클래스(base class)   | 파생 클래스(derived class) |
| 부모 클래스(parent class) | 자식 클래스(child class)   |
| 상위 클래스(superclass)   | 하위 클래스(subclass)      |

- 접근 제한자

| 키워드       |                                       |
|-----------|---------------------------------------|
| private   | class 내부에서만 접근 가능, 자식 클래스에서도 접근할 수 없음 |
| protected | 자식 클래스에서 접근 가능, 외부에서 접근 x             |

- `open fun()`을 `override`해서 멤버 함수를 재정의 할 수 있다.
- `super`를 통해 부모 클래스에 접근 가능
- 부모 클래스에 생성자 파라미터가 있다면 인자를 제공 해야함
    - 부생성자를 정의 할 때 `this`, `super`키워드 사용가능

[코드 참조](Inheritance.kt)

### Abstract

- 추상 클래스(Abstract class): 하나 이상의 프로퍼티나 함수가 불완전함
    - 함수를 구현하지 않거나 초깃값을 대입하지 않은 프로퍼티를 불완전하다고 함
- 구체화가 필요한 프로퍼티나 함수에는 `abstract`키워드를 사용한다.


|                 | Interface         | Abstract class | Open class | Class |
|-----------------|-------------------|----------------|------------|-------|
| 프로퍼티 값 저장       | 불가능 (getter 사용가능) | 가능             | 가능         | 가능    |
| abstract member | default           | 별도 지정          | 불가능        | 불가능   |
| 함수 구현           | 가능                | 가능             | 가능         | 가능    |
| 상속              | 가능                | 가능             | 가능         | 불가능   |
| 다중 상속           | 가능                | 불가능            | 불가능        | 불가능   |

- 다중 상속을 이용할 때 같은 시그니처가 존재할 경우 충돌을 해결 해야함
```kotlin
interface A {
    fun callName() = "A"
    val numA: Double
        get() = 1.1
}

interface B {
    fun callName() = "B"
    val numB: Double
        get() = 2.2
}

class C: A, B {
    // 시그니처가 같은 멤버가 있을때 이를 처리하지 않으면 오류 발생 
    override fun callName() = super<A>.callName() 
}

fun main() {
    val c = C()
    println("c.callName(): ${c.callName()}")
    println("c.numA: ${c.numA}")
    println("c.numB: ${c.numB}")
}
```

### Upcasting
- 하위 클래스 타입을 상위 클래스 타입으로 변환하는 것
- 추상화를 통해 중복 제거

- 치환 가능성: 리스코프 치환 원칙(Liskov Substitution Principle)
  - 서브타입은 그것의 기반 타입(베이스 타입)으로 교체할 수 있어야 한다
  - 업캐스트가 하위 클래스에 추가된 멤버 함수를 잘라버림

[코드 참조](Upcasting.kt)

### Polymorphism
- 다형성: 동일한 인터페이스나 상위 클래스에서 정의된 메소드를 하위 클래스에서 각각 다르게 구현하여, 동일한 메소드 호출이 다양한 방식으로 동작하도록 하는 것
- 업캐스팅한 클래스 멤버 호출시 다형성에 의해 자식 클래스가 오버라이드한 멤버를 호출


- 바인딩(binding)
  - 함수 호출을 함수 본문과 연결 짓는 작업
  - 일반적으로 정적 바인딩으로, 컴파일 시점에 일어남
- 동적 바인딩(late binding)
  - 다형성이 사용되는 경우 런타임에 바인딩이 일어나고 동적 바인딩, 동적 디스패치(dispatch)라고 함
  - 런타임에 타입을 결정하는 추가 로직이 성능에 부정적 영향
  - 상속과 오버라이딩을 할 때 코드에 의도를 명확히 드러내야함

[코드 참조](Polymorphism.kt)


### 합성
- 기존 코드를 더럽히지 않고 재사용 하는 방법: 상속, 합성
- 합성: 새로운 class에서 기존 class 객체를 사용하는 것
  - 기존 코드의 형태가 아니라 기능을 재사용 하기 위해

### 상속과 확장
- 상속을 하면서 함수를 추가하는 건 부모 클래스가 있다는 사실을 무시하고, 시스템 전반에서 자식 클래스를 엄격하게 식별해 취급할 때 유용
- 필수적인 함수만 포함하는 간단한 인터페이스를 만들고, 부가 함수를 확장으로 정의하라
- 어댑터 패턴: 상속을 할 수 없다면 합성으로 사용하면 된다.
- 확장 함수는 `private`멤버에 접근 할 수 없기 때문에 접근해야 한다면 멤버 함수를 정의 해야한다.

> 함수만으로 충분한 경우가 많다. 가끔은 객체가 매우 유용하다. 객체는 다양한 도구 중 하나일 뿐이며, 모든 경우에 적용할 수 있는 도구는 아니다.

### 클래스 위임(Class Delegation)
- 인터페이스가 구현된 객체를 재사용하고 인터페이스를 노출 시킨다.
- 위임한 인터페이스로 업캐스팅할 수 있다.
- 다중 상속을 흉내낼 수 있다.

```kotlin
interface Logger {
    fun log(message: String)
}

class DefaultLogger(val tag: String): Logger {
    override fun log(message: String) {
        println("$tag| $message")
    }
}

interface Activity {
    fun onCreate()
    fun onStart()
    fun onResume()
}

class MainActivity(
    private val logger: DefaultLogger
): Activity, Logger by logger {
    init {
        onCreate()
        onStart()
        onResume()
    }

    override fun onCreate() {
        log("onCreate")
    }

    override fun onStart() {
        log("onStart")
    }

    override fun onResume() {
        log("onResume")
    }
}


fun main() {
    val mainActivity = MainActivity(DefaultLogger("MainActivity"))
    val mainActivityLogger: Logger = mainActivity
    mainActivityLogger.log("finished init")
}
```


### 다운캐스트
- 구체적인 타입으로 참조
- 런타임에 일어나며 실행 시점 타입 식별(Run-Time Type Identification, RTTI)이라고도 함

[코드 참조](Downcasting.kt)


### Sealed Class(봉인된 클래스)
- `sealed class`를 상속한 자식 클래스들은 반드시 부모 클래스와 같은 패키지와 모듈 안에 있어야 한다.
- 상속을 제한하여 다운캐스팅을 효과적으로 사용할 수 있다.

[코드 참조](Sealed.kt)


### 타입 검사
- `sealed class`를 이용해 `when`사용시 모든 타입을 검사하도록 보장할 수 있다.
- 필요에 따라 확장 함수와 타입 검사를 이용하거나, `abstract`멤버를 이용해 설계할 수 있다.

[코드 참조](TypeChecking.kt)

### 내포된 클래스
내포된 클래스: `class`안에 정의한 또 다른 `class`
- 외부 클래스의 `private 멤버`에 접근할 수 있다.
- `import`를 통해 외부에서 사용할 수 있다.
- 내포된 클래스가 `private`이라면 외부로 반환할 수 없다.
- [코드 참조](nested/Airport.kt)

<br />

지역 클래스: 함수안에 내포된 클래스
- 지역 interface 사용 할 수 없음
- 지역 open class 사용 지양
- 지역 클래스를 반환할 수 없다.
```kotlin
interface Amphibian

fun createAmphibian(): Amphibian {
  class Frog : Amphibian
  return Frog()
}

fun main() {
  val amphibian = createAmphibian()
  // 다음과 같이 다운캐스트시 컴파일 오류가 발생한다
  // amphibian as Frog
}
```

<br />

인터페이스 안에 클래스를 내포시킬 수 있다.

```kotlin
interface Item {
    val type: Type
    data class Type(val type: String)
}

class Bolt(type: String) : Item {
    override val type = Item.Type(type)
}

fun main() {
    val items = listOf(
        Bolt("Slotted"), Bolt("Hex")
    )
    items.map(Item::type) eq
            "[Type(type=Slotted), Type(type=Hex)]"
}
```

<br />

내포된 이넘
- Enum은 함수에 내포시킬 수 없음
- Enum은 다른 클래스를 상속할 수 없음
- [코드 참조](nested/Ticket.kt)


### Object
- `Singleton` 인스턴스: 생성자를 통해 생성할 수 없고 오직 하나의 인스턴스만 생김
- `private`으로 선언하면 현재 파일 안에서만 사용
- 파라미터 목록 X
- 파스칼 케이스로 정의
- 다른 class, interface를 상속할 수 있다.
- 함수 안에 내포시킬 수 없다.
- 다른 object, class안에 내포시킬 수 있다.

```kotlin
open class Paint(val color: String) {
    open fun apply() = "Applying $color"
}

object Acrylic: Paint("Blue") {
    override fun apply() = "Acrylic, ${super.apply()}"
}

interface PaintPreparation {
    fun prepare(): String
}

object Prepare: PaintPreparation {
    override fun prepare() = "Scrape"
}

fun main() {
    Prepare.prepare() eq "Scrape"
    Paint("Green").apply() eq "Applying Green"
    Acrylic.apply() eq "Acrylic, Applying Blue"
}
```

```kotlin
object NcsTypography {
    val Music = MusicTypography
  // ...

    object MusicTypography {
        val Title = TitleTypography
      // ...

        object TitleTypography {
            val large = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            )
          // ...
        }
    }
  // ...
}
```


### Inner class
- 내포된 class와 다르게 자신을 감싸는 class의 멤버를 직접 참조할 수 있다.
- 내포된 class는 inner class를 상속할 수 없다.
- inner class를 생성하려면 감싸는 class의 객체가 필요하다.
- inner data class는 사용할 수 없다.

```kotlin
class Hotel(private val reception: String) {
    open inner class Room(val id: Int = 0) {
        fun callReception() = "Room $id Calling $reception" // reception 접근
    }
    private inner class Closet : Room()
    fun closet(): Room = Closet()
}

fun main() {
    val nycHotel = Hotel("311")
    val room = nycHotel.Room(319) // 내부 클래스의 인스턴스를 생성하려면 그 내부 클래스를 둘러싼 클래스의 인스턴스가 필요하다
    room.callReception() eq "Room 319 Calling 311"
    val sfHotel = Hotel("0")
    val closet = sfHotel.closet() // Hotel.Room으로 업캐스팅 된다.
    closet.callReception() eq "Room 0 Calling 0"
}
```

- 한정된 `this`를 이용해 현재 객체나 외불 객체를 참조할 수 있다.
[코드 참조](QualifiedThis.kt)
- inner class는 다른 외부 class에 있는 inner class를 상속할 수 있다.
[코드 참조](InnerClassInheritance.kt)

`지역 내부 클래스`: 멤버 함수 안에 정의된 class
- object expression, SAM 변환을 사용해 익명으로 생성할 수 있다.
- inner 키워드를 사용하지 않지만 암시적으로 inner class가 된다.
- [코드 참조](LocalInnerClasses.kt)
```kotlin
fun interface Pet {
    fun speak(): String
}

object CreatePet {
    fun home() = " home!"
    fun dog(): Pet {
        val say = "Bark"
        // 지역 내부 클래스
        class Dog : Pet {
            override fun speak() = say + home()
        }
        return Dog()
    }
    fun cat(): Pet {
        val emit = "Meow"
        // 익명 내부 클래스
        return object: Pet {
            override fun speak() = emit + home()
        }
    }
    fun hamster(): Pet {
        val squeak = "Squeak"
        // SAM 변환
        return Pet { squeak + home() }
    }
}
```


### Companion Object
- class 안에 `companion object` 블록에 작성한 코드
- 인스턴스 없이 호출할 수 있다.
- class 멤버에 직접 접근할 수 없다.
- 확장함수를 사용할 수 있다.
- 클래스당 하나만 허용
- 이름 부여 가능(Default: Companion)
- 프로퍼티 생성시 모든 인스턴스가 공유한다.
- [코드 참조](CompanionObject.kt)
```kotlin
data class User(
    val id: Int,
    val name: String
) {
    companion object Com {
        private var count = 0
        fun createMock(): User = User(
            id = count++,
            name = "Mock User"
        )
    }

    fun increment() = ++count
}

fun main() {
    val mockUser = User.createMock()
    val mockUser2 = User.Com.createMock()

    println(mockUser)
    println(mockUser2)
    println(mockUser.increment())
    println(mockUser2.increment())
    println(mockUser.increment())
    println(mockUser2.increment())

    val mockUsr3 = User.createMock()
    println(mockUsr3)
}
```
- 상속할 수 있다.
- `companion object`로 `delegation`을 사용할 수 있다. [코드 참조](CompanionInstance.kt)
```kotlin
interface ZI {
    fun f(): String
    fun g(): String
}

interface Extended: ZI {
    fun u(): String
}

class Extend : ZI by Companion, Extended {
    companion object: ZI {
        override fun f() = "Extend.f()"
        override fun g() = "Extend.g()"
    }
    override fun u() = "${f()} ${g()}"
}

private fun test(e: Extended): String {
    e.f()
    e.g()
    return e.u()
}

fun main() {
    test(Extend()) eq "Extend.f() Extend.g()"
}
```
- 팩토리 메서드로 사용할 수 있다. [코드 참조](CompanionFactory.kt)
```kotlin
class PrivateUser private constructor(
    val id: Int,
    val name: String
) {
    companion object Factory {
        private var count: Int = 0
        fun create(name: String): PrivateUser = PrivateUser(
            id = count++,
            name = name
        )
    }

    override fun toString(): String = "[PrivateUser(id:$id, name:$name)]"
}

fun main() {
    val users = List(10) { PrivateUser.create("User $it") }
    println(users)
}
```
- class가 처음으로 사용될때 companion object가 초기화 된다. [코드 참조](Initialization.kt)
```kotlin
class CompanionInit {
    companion object {
        init {
            println("Companion Constructor")
        }
    }
}

fun main() {
    println("Before")
    CompanionInit()
    println("After 1")
    CompanionInit()
    println("After 2")
    CompanionInit()
    println("After 3")
}
```