package chapter5.moonggae.nested

import atomictest.eq
import chapter5.moonggae.nested.Airport.Plane

class Airport(private val code: String) {
    open class Plane {
        // 자신을 둘러싼 클래스의 private 프로퍼티에 접근할 수 있다
        fun contact(airport: Airport) =
            "Contacting ${airport.code}"
    }
    private class PrivatePlane : Plane()
    fun privatePlane(): Plane = PrivatePlane()
}

fun main() {
    val denver = Airport("DEN")
    var plane = Plane()
    plane.contact(denver) eq "Contacting DEN"

//    val privatePlane = Airport.PrivatePlane() // private class에 접근할 수 없음
    val frankfurt = Airport("FRA")
    plane = frankfurt.privatePlane()

//    val p = plane as PrivatePlane // private class로 다운캐스팅 할 수 없음
    plane.contact(frankfurt) eq "Contacting FRA"
}