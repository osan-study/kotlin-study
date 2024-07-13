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