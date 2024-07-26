package chapter5.moonggae.nested


fun localClasses() {
    open class Amphibian
    class Frog : Amphibian()
    val amphibian: Amphibian = Frog()
}

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