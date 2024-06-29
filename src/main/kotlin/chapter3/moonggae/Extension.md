## 30. Extension Functions and Properties

- 기존 클래스의 public 멤버를 이용해 확장 함수, 확장 프로퍼티를 정의할 수 있다.
- 확장 프로퍼티는 접근자에서는 field 키워드를 이용할 수 없다.

[참조: Kotlin Example](https://play.kotlinlang.org/byExample/04_functional/03_extensionFunctions)

```kotlin
// Extension.kt

class Book(
    val title: String,
    val content: String,
    val price: Int
) {
    var salePrice: Int = price
}

fun Book.getContentSize(): Int = content.count()

val Book.titleSize: Int get() = title.count()

var Book.discountPrice: Int
    get() = price - salePrice
    set(value) { salePrice = price - value }

fun main() {
    val kotlinBook = Book(
        title = "Atomic Kotlin",
        content = "코틀린의 기본 개념을 명확히 이해하고, 더 나은 코드를 작성하기 위한 87가지 필수 개념을 배울 수 있다.",
        price = 100_000
    )

    println("kotlinBook.getContentSize(): ${kotlinBook.getContentSize()}")
    println("kotlinBook.titleSize: ${kotlinBook.titleSize}")
    println("kotlinBook.price: ${kotlinBook.price}")

    kotlinBook.discountPrice = 30_000
    println("\n// kotlinBook.discountPrice = 30_000")
    println("kotlinBook.discountPrice: ${kotlinBook.discountPrice}")
    println("kotlinBook.salePrice: ${kotlinBook.salePrice}")

    kotlinBook.salePrice = 50_000
    println("\n// kotlinBook.salePrice = 50_000")
    println("kotlinBook.discountPrice: ${kotlinBook.discountPrice}")
    println("kotlinBook.salePrice: ${kotlinBook.salePrice}")
}
```

> 라이브러리의 클래스를 확장하거나, <br/>
> 아키텍처의 제약 사항 때문에 다른 모듈에서 구현할 수 없는 멤버를 구현할 때 유용 <br/>

Example
```kotlin
// model 모듈 - android 라이브러리 사용 x
package com.ccc.ncs.model

interface MusicTag {
    val id: Int
    val name: String
    val colorInt: Int?
    val backgroundColorInt: Int?
}
```


```kotlin
// app 모듈 - android 라이브러리 사용 o
package com.ccc.ncs.ui.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ccc.ncs.model.MusicTag

@Composable
fun MusicTag.color(): Color = this.colorInt?.let {
    return Color(it)
} ?: Color(0xFFD6D6D6)

@Composable
fun MusicTag.backgroundColor(): Color = this.backgroundColorInt?.let {
    return Color(it)
} ?: Color.DarkGray
```