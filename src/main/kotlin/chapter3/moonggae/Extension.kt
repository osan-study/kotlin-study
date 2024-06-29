package chapter3.moonggae

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