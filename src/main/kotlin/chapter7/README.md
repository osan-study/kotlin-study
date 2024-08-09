# Atomic 81 제네릭스 만들기

> 정해지지 않은 타입을 `제네릭 타입 파라미터(generic type parameter)` 라고 부른다


## Any

Any는 코틀린 클래스 계층의 루티이며, 모든 코틀린 클래스는 Any를 상위 클래스로 갖는다.

Any를 사용하는 방법은 2가지이다.

- Any를 타입으로 받아 해당 Any에 대해서만 사용하는 방법 (제한적) equals(), hashCode(), toString() 3가지 뿐.
- 확장함수를 통한 방식은 Any타입 객체에 대해 직접 연산은 할 수 없다. Any.xx()라고 선언하더라도 Any에 대해서만 적용될 뿐이고
Any 타입 객체의 내부 연산을 직접 호출할 수 없다.

Any를 사용한 방법은 지양하는 것이 좋다고 본다. 

타입을 구체적인 타입에 따른 수행을 하더라도 타입을 변환하다가 잘모된 타입을 지정하면 런타임 오류가 발생할 가능성이 있으며, 다운 캐스트를 해야하기 떄문.


```kotlin

class Person {
    fun speak() = "HI"
}

class Dog {
    fun bark() = "Ruff";
}

class Robot {
    fun communicate() = "삐빅"
}

fun talk(speaker : Any) = when (speaker) {
    
    is Person -> speaker.speak()
    is Dog -> speaker.bark()
    is Robot -> speaker.communicate()
    else -> "Not a Talker"
}
```

변경할 일이 없다면 지금 당장 해당 코드를 사용할만 하다, 하지만 지속적으로 추가되거나 변경될 가능성이 있다면
타입을 추가하거나 삭제할대마다 talk()함수를 변경해야하고 타입에 맞춰서 매번 수정을 해야한다. 

## 제네릭스 정의하기

> 제네릭스는 두 홑화살괄호 <> 안에 제네릭 플레이스홀더를 하나 이상 넣으면 제네릭 함수나 타입을 정의할 수 있다. 주로 제네릭 파라미터는
> T로 지정하긴 하나 원하는 단어로 작성하여도 괜찮다.